package com.sharepower.JKutkh.structure.config.target;

import lombok.Getter;
import lombok.Setter;

/**
 * @date 2021/1/21
 * @author chenguang
 * @desc http target config
 */
@Getter
@Setter
public class HttpTargetConfig extends TargetConfig {

    /**
     * @date 2021/1/21
     * @author chenguang
     * @desc http result config
     */
    private ResultConfig resultConfig;

}
