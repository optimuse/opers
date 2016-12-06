package com.bestpay.ecurrency.operations.manager.core.callback;

import com.bestpay.ecurrency.core.router.model.RequestModel;
import com.bestpay.ecurrency.core.router.model.ResponseModel;
import com.bestpay.ecurrency.core.util.XxlJobNetCommUtil;
import com.bestpay.ecurrency.operations.dal.model.XxlJobInfoDO;
import com.bestpay.ecurrency.operations.dal.model.XxlJobLogDO;
import com.bestpay.ecurrency.operations.manager.core.util.DynamicSchedulerUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.quartz.SchedulerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Date;

/**
 * Created by xuxueli on 2016-5-22 11:15:42
 */
@Slf4j
public class XxlJobLogCallbackServerHandler extends AbstractHandler {

	@Override
	public void handle(String s, Request baseRequest, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {

		httpServletRequest.setCharacterEncoding("UTF-8");
		httpServletResponse.setCharacterEncoding("UTF-8");

		// parse hex-json to request model
		String requestHex = httpServletRequest.getParameter(XxlJobNetCommUtil.HEX);

		// do biz
		ResponseModel responseModel = dobiz(requestHex);

		// format response model to hex-json
		String responseHex = XxlJobNetCommUtil.formatObj2HexJson(responseModel);

		// response
		httpServletResponse.setContentType("text/html;charset=utf-8");
		httpServletResponse.setStatus(HttpServletResponse.SC_OK);
		baseRequest.setHandled(true);
		httpServletResponse.getWriter().println(responseHex);
	}

	private ResponseModel dobiz(String requestHex){

		// valid hex
		if (requestHex==null || requestHex.trim().length()==0) {
			return new ResponseModel(ResponseModel.FAIL, "request hex is null.");
		}

		// valid request model
		RequestModel requestModel = XxlJobNetCommUtil.parseHexJson2Obj(requestHex, RequestModel.class);
		if (requestModel==null) {
			return new ResponseModel(ResponseModel.FAIL, "request hex parse fail.");
		}

		// valid log item
		XxlJobLogDO xxlJobLogDO = DynamicSchedulerUtil.xxlJobLogDao.load(requestModel.getLogId());
		if (xxlJobLogDO == null) {
			return new ResponseModel(ResponseModel.FAIL, "log item not found.");
		}

		// trigger success, to trigger child job, and avoid repeat trigger child job
		String childTriggerMsg = null;
		if (ResponseModel.SUCCESS.equals(requestModel.getStatus()) && !ResponseModel.SUCCESS.equals(xxlJobLogDO.getHandleStatus())) {
			XxlJobInfoDO xxlJobInfo = DynamicSchedulerUtil.xxlJobInfoDao.load(xxlJobLogDO.getJobGroup(), xxlJobLogDO.getJobName());
			if (xxlJobInfo!=null && StringUtils.isNotBlank(xxlJobInfo.getChildJobKey())) {
				childTriggerMsg = "<hr>";
				String[] childJobKeys = xxlJobInfo.getChildJobKey().split(",");
				for (int i = 0; i < childJobKeys.length; i++) {
					String[] jobKeyArr = childJobKeys[i].split("_");
					if (jobKeyArr!=null && jobKeyArr.length==2) {
						XxlJobInfoDO childJobInfo = DynamicSchedulerUtil.xxlJobInfoDao.load(Integer.valueOf(jobKeyArr[0]), jobKeyArr[1]);
						if (childJobInfo!=null) {
							try {
								boolean ret = DynamicSchedulerUtil.triggerJob(childJobInfo.getJobName(), String.valueOf(childJobInfo.getJobGroup()));

								// add msg
								childTriggerMsg += MessageFormat.format("<br> {0}/{1} 触发子任务成功, 子任务Key: {2}, status: {3}, 子任务描述: {4}",
										(i+1), childJobKeys.length, childJobKeys[i], ret, childJobInfo.getJobDesc());
							} catch (SchedulerException e) {
								log.error("", e);
							}
						} else {
							childTriggerMsg += MessageFormat.format("<br> {0}/{1} 触发子任务失败, 子任务xxlJobInfo不存在, 子任务Key: {2}",
									(i+1), childJobKeys.length, childJobKeys[i]);
						}
					} else {
						childTriggerMsg += MessageFormat.format("<br> {0}/{1} 触发子任务失败, 子任务Key格式错误, 子任务Key: {2}",
								(i+1), childJobKeys.length, childJobKeys[i]);
					}
				}

			}
		}

		// success, save log
		xxlJobLogDO.setHandleTime(new Date());
		xxlJobLogDO.setHandleStatus(requestModel.getStatus());
		xxlJobLogDO.setHandleMsg(requestModel.getMsg() + childTriggerMsg);
		DynamicSchedulerUtil.xxlJobLogDao.updateHandleInfo(xxlJobLogDO);

		return new ResponseModel(ResponseModel.SUCCESS, null);
	}

}
