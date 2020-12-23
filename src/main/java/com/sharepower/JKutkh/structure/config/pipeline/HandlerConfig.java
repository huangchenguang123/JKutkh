package com.sharepower.JKutkh.structure.config.pipeline;

import com.sharepower.JKutkh.structure.config.base.Config;

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
     * @date 2020/12/23
     * @author chenguang
     * @desc jar path
     */
    private String url;

    /**
     * @date 2020/12/23
     * @author chenguang
     * @desc class name
     */
    private String className;

}
