package com.sharepower.JKutkh.app.sync;

import com.sharepower.JKutkh.app.base.App;
import com.sharepower.JKutkh.config.base.AppConfig;
import com.sharepower.JKutkh.config.base.Config;
import com.sharepower.JKutkh.source.base.Source;
import com.sharepower.JKutkh.source.sync.HttpSyncSource;

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

}
