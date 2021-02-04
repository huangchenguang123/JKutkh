package com.sharepower.JKutkh.structure.config.source;

import com.sharepower.JKutkh.structure.config.base.Config;
import com.sharepower.JKutkh.structure.config.rule.RuleValidateConfig;

import lombok.Getter;
import lombok.Setter;

/**
 * @date 2020/12/14
 * @author chenguang
 * @desc source config
 */
@Getter
@Setter
public class SourceConfig extends Config {

    /**
     * @date 2020/12/23
     * @author chenguang
     * @desc source type
     */
    protected String sourceType;

    /**
     * @date 2021/1/21
     * @author chenguang
     * @desc ruleValidateConfig
     */
    private RuleValidateConfig ruleValidateConfig;

}
