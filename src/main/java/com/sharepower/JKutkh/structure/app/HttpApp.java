package com.sharepower.JKutkh.structure.app;

import com.sharepower.JKutkh.common.enums.ExecuteEnums;
import com.sharepower.JKutkh.structure.config.base.AppConfig;
import com.sharepower.JKutkh.structure.config.base.Config;
import com.sharepower.JKutkh.structure.pipeline.Pipeline;
import com.sharepower.JKutkh.structure.source.Source;
import com.sharepower.JKutkh.structure.target.Target;

import java.util.Map;

/**
 * @date 2020/12/18
 * @author chenguang
 * @desc http server app
 */
public class HttpApp extends App {

    /**
     * @date 2020/12/22
     * @author chenguang
     * @desc init source
     */
    @Override
    protected void initSource(Config config) {
        // cast type
        AppConfig appConfig = (AppConfig) config;
        // init source
        this.source = Source.getSource(appConfig.getSourceConfig(), this);;
    }

    /**
     * @date 2020/12/22
     * @author chenguang
     * @desc init pipeline
     */
    @Override
    protected void initPipeline(Config config) {
        // cast type
        AppConfig appConfig = (AppConfig) config;
        // init pipeline
        this.pipeline = Pipeline.getPipeline(appConfig.getPipelineConfig(), this);;
    }

    /**
     * @date 2020/12/22
     * @author chenguang
     * @desc init target
     */
    @Override
    protected void initTarget(Config config) {
        // cast type
        AppConfig appConfig = (AppConfig) config;
        // init target
        this.target = Target.getTarget(appConfig.getTargetConfig(), this);
    }

    /**
     * @date 2020/12/17
     * @author chenguang
     * @desc before execute, you want to do something
     */
    @Override
    protected void beforeExecute(Map<String, Object> data) {
        data.put(ExecuteEnums.class.getSimpleName(), ExecuteEnums.SUCCESS);
    }

}
