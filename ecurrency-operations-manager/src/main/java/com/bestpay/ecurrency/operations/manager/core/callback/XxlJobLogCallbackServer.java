package com.bestpay.ecurrency.operations.manager.core.callback;

import com.bestpay.ecurrency.core.util.IpUtil;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.util.thread.ExecutorThreadPool;

/**
 * Created by xuxueli on 2016-5-22 11:15:42
 */
@Slf4j
public class XxlJobLogCallbackServer {

    private static String trigger_log_address;
    public static String getTrigger_log_address() {
		return trigger_log_address;
	}
    
    Server server = null;
    public void start(int callBackPort) throws Exception {
    	// init address
    	
    	String ip = IpUtil.getIp();
    	trigger_log_address = ip.concat(":").concat(String.valueOf(callBackPort));
		
    	final int port = Integer.valueOf(callBackPort);
        new Thread(new Runnable() {
            @Override
            public void run() {
                server = new Server();
                server.setThreadPool(new ExecutorThreadPool(200, 200, 30000));	// 非阻塞

                // connector
                SelectChannelConnector connector = new SelectChannelConnector();
                connector.setPort(port);
                connector.setMaxIdleTime(30000);
                server.setConnectors(new Connector[] { connector });

                // handler
                HandlerCollection handlerc =new HandlerCollection();
                handlerc.setHandlers(new Handler[]{new XxlJobLogCallbackServerHandler()});
                server.setHandler(handlerc);

                try {
                    server.start();
                    log.info(">>>>>>>>>>>> xxl-job XxlJobCallbackServer start success at port:{}.", port);
                    server.join();  // block until server ready
                    log.info(">>>>>>>>>>>> xxl-job XxlJobCallbackServer join success at port:{}.", port);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

	public void destroy() {
		if (server!=null) {
			try {
				server.stop();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
