package com.sharepower.JKutkh.structure.source.sync;

import com.sharepower.JKutkh.structure.app.base.App;
import com.sharepower.JKutkh.structure.app.sync.HttpApp;
import com.sharepower.JKutkh.structure.config.base.Config;
import com.sharepower.JKutkh.structure.config.source.HttpSourceConfig;
import com.sharepower.JKutkh.dispatch.sync.HttpSyncDispatch;
import com.sharepower.JKutkh.structure.source.base.Source;
import com.sharepower.JKutkh.utils.SpringContextUtils;

import java.util.Map;

import lombok.SneakyThrows;

/**
 * @date 2020/12/14
 * @author chenguang
 * @desc http source
 *
 * all http request will input into this source
 */
public class HttpSyncSource implements Source {

    /**
     * @date 2020/12/22
     * @author chenguang
     * @desc http app
     */
    private HttpApp httpApp;

    /**
     * @date 2020/12/14
     * @author chenguang
     * @desc input data and execute
     */
    @Override
    public void execute(Map<String, Object> data) {
    }

    /**
     * @date 2020/12/22
     * @author chenguang
     * @desc init http source
     */
    @Override
    @SneakyThrows
    public void init(Config config, App app) {
        httpApp = (HttpApp) app;
        // register http source
        HttpSyncDispatch httpDispatch = SpringContextUtils.getBean(HttpSyncDispatch.class);
        HttpSourceConfig sourceConfig = (HttpSourceConfig) config;
        httpDispatch.register(sourceConfig.getDomain(), sourceConfig.getMethod(), httpApp);
    }

}
