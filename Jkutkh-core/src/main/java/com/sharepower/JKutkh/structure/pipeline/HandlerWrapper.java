package com.sharepower.JKutkh.structure.pipeline;

import com.sharepower.JKutkh.structure.rule.RuleValidate;

import lombok.Getter;
import lombok.Setter;

/**
 * @date 2021/2/4
 * @author chenguang
 * @desc hander wapper has hander and rule validate
 */
@Getter
@Setter
public class HandlerWrapper {

    /**
     * @date 2021/1/21
     * @author chenguang
     * @desc rule validate
     */
    private RuleValidate ruleValidate;

    /**
     * @date 2021/2/4
     * @author chenguang
     * @desc handler
     */
    private Handler handler;

}
