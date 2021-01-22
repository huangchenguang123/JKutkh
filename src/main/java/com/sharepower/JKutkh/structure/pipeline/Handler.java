package com.sharepower.JKutkh.structure.pipeline;

import com.sharepower.JKutkh.structure.rule.RuleValidate;

import java.util.Map;

/**
 * @date 2020/12/22
 * @author chenguang
 * @desc one block of pipeline
 */
public abstract class Handler {

    /**
     * @date 2021/1/21
     * @author chenguang
     * @desc rule validate
     */
    protected RuleValidate ruleValidate;

    /**
     * @date 2020/12/22
     * @author chenguang
     * @desc business logic
     */
    protected abstract boolean run(Map<String, Object> data);

}
