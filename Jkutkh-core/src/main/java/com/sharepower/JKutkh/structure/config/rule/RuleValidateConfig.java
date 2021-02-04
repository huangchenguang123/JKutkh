package com.sharepower.JKutkh.structure.config.rule;

import com.sharepower.JKutkh.structure.config.base.Config;

import lombok.Getter;
import lombok.Setter;

/**
 * @date 2021/1/21
 * @author chenguang
 * @desc rule validate config
 */
@Getter
@Setter
public class RuleValidateConfig extends Config {

    /**
     * @date 2021/1/21
     * @author chenguang
     * @desc qlExpress
     *
     * https://github.com/alibaba/QLExpress
     */
    private String qlExpress;

}
