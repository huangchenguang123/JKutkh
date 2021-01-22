package com.sharepower.JKutkh.structure.config.target;

import com.sharepower.JKutkh.structure.config.base.Config;
import com.sharepower.JKutkh.structure.config.rule.RuleValidateConfig;

import lombok.Getter;
import lombok.Setter;

/**
 * @date 2020/12/23
 * @author chenguang
 * @desc target config
 */
@Getter
@Setter
public class TargetConfig extends Config {

    /**
     * @date 2020/12/23
     * @author chenguang
     * @desc target type
     */
    protected String targetType;

    /**
     * @date 2021/1/21
     * @author chenguang
     * @desc ruleValidateConfig
     */
    private RuleValidateConfig ruleValidateConfig;

}
