package com.sharepower.JKutkh.structure.config.pipeline;

import com.sharepower.JKutkh.structure.config.base.Config;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * @date 2020/12/22
 * @author chenguang
 * @desc pipeline config
 */
@Getter
@Setter
public class PipelineConfig extends Config {

    /**
     * @date 2020/12/23
     * @author chenguang 
     * @desc handler config list
     */
    private List<HandlerConfig> handlerConfigs;

}
