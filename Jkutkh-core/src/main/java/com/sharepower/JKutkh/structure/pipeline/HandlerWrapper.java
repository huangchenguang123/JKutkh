package com.sharepower.JKutkh.structure.pipeline;

import com.sharepower.JKutkh.structure.rule.RuleValidate;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * @date 2021/2/4
 * @author chenguang
 * @desc handler wrapper has handler and rule validate
 */
@Getter
@Setter
public class HandlerWrapper {

    /**
     * @date 2021/2/7
     * @author chenguang
     * @desc handler id, is used to mark when to run this handler
     */
    private Long id;

    /**
     * @date 2021/2/7
     * @author chenguang
     * @desc parent must run first
     */
    private List<Long> parent;

    /**
     * @date 2021/2/7
     * @author chenguang
     * @desc children must run next
     */
    private List<Long> children;

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
