package com.sharepower.JKutkh.structure.config.pipeline;

import com.sharepower.JKutkh.structure.config.base.Config;
import com.sharepower.JKutkh.structure.config.rule.RuleValidateConfig;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * @date 2020/12/23
 * @author chenguang
 * @desc handler config
 */
@Getter
@Setter
public class HandlerConfig extends Config {

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
     * @date 2021/2/7
     * @author chenguang
     * @desc class id
     */
    private Long classId;

    /**
     * @date 2020/12/23
     * @author chenguang
     * @desc class path
     */
    private String url;

    /**
     * @date 2020/12/23
     * @author chenguang
     * @desc class name
     */
    private String className;

    /**
     * @date 2021/1/21
     * @author chenguang
     * @desc ruleValidateConfig
     */
    private RuleValidateConfig ruleValidateConfig;

}
