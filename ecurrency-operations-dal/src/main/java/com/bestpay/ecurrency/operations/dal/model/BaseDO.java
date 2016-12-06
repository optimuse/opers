package com.bestpay.ecurrency.operations.dal.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 数据基础模型
 * User: wen  Date: 2015/09/23 ProjectName: ecurreccy-operations Version: 1.0
 */
@Getter
@Setter
@ToString
public class BaseDO {

    /**
     * 状态
     */
    public enum Stat{
        S0A("有效"),
        S0L("无效")
        ;

        private String desc;

        Stat(String desc) {
            this.desc = desc;
        }

        public String desc() {
            return desc;
        }
    }

}
