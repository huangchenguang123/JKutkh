package com.sharepower.JKutkh.structure.app.sync;

import com.sharepower.JKutkh.structure.config.base.AppConfig;
import com.sharepower.JKutkh.structure.config.base.Config;
import com.sharepower.JKutkh.structure.pipeline.Pipeline;
import com.sharepower.JKutkh.structure.source.base.Source;
import com.sharepower.JKutkh.structure.source.sync.HttpSyncSource;
import com.sharepower.JKutkh.structure.app.base.App;

import java.util.Map;

import lombok.Getter;
import lombok.SneakyThrows;

/**
 * @date 2020/12/18
 * @author chenguang
 * @desc http server app
 */
@Getter
public class HttpApp extends App {

    /**
     * @date 2020/12/22
     * @author chenguang
     * @desc source
     */
    private Source source;

    /**
     * @date 2020/12/23
     * @author chenguang
     * @desc pipeline
     */
    private Pipeline pipeline;

    /**
     * @date 2020/12/22
     * @author chenguang
     * @desc before init, you want to do something
     */
    @Override
    @SneakyThrows
    public void before(Config config) {
    }

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
        Source source = new HttpSyncSource();
        source.init(appConfig.getSourceConfig(), this);
        this.source = source;
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
        // init source
        Pipeline pipeline = new Pipeline();
        pipeline.init(appConfig.getPipelineConfig(), this);
        this.pipeline = pipeline;
    }

    /**
     * @date 2020/12/22
     * @author chenguang
     * @desc init target
     */
    @Override
    protected void initTarget(Config config) {
    }

    /**
     * @date 2020/12/17
     * @author chenguang
     * @desc after init, you want to do something
     */
    @Override
    protected void after(Config config) {
    }

    /**
     * @date 2020/12/23
     * @author chenguang
     * @desc input data and execute
     */
    @Override
    public Map<String, Object> execute(Map<String, Object> data) {
        return null;
    }

}
