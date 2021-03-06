package com.sharepower.JKutkh.structure.config.base;

import com.sharepower.JKutkh.structure.config.pipeline.PipelineConfig;
import com.sharepower.JKutkh.structure.config.source.SourceConfig;
import com.sharepower.JKutkh.structure.config.target.TargetConfig;

import lombok.Getter;
import lombok.Setter;

/**
 * @date 2020/12/18
 * @author chenguang
 * @desc app config
 */
@Getter
@Setter
public class AppConfig extends Config {

    /**
     * @date 2020/12/22
     * @author chenguang
     * @desc source config
     */
    private SourceConfig sourceConfig;

    /**
     * @date 2020/12/23
     * @author chenguang
     * @desc pipeline config
     */
    private PipelineConfig pipelineConfig;

    /**
     * @date 2020/12/23
     * @author chenguang
     * @desc target config
     */
    private TargetConfig targetConfig;

}
