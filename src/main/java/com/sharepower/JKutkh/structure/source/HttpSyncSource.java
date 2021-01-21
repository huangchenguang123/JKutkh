package com.sharepower.JKutkh.structure.source;

import com.sharepower.JKutkh.common.utils.SpringContextUtils;
import com.sharepower.JKutkh.dispatch.HttpSyncDispatch;
import com.sharepower.JKutkh.structure.app.App;
import com.sharepower.JKutkh.structure.app.HttpApp;
import com.sharepower.JKutkh.structure.config.source.HttpSourceConfig;
import com.sharepower.JKutkh.structure.config.source.SourceConfig;

import java.util.Map;

import lombok.SneakyThrows;

/**
 * @date 2020/12/14
 * @author chenguang
 * @desc http source
 *
 * all http request will input into this source
 */
public class HttpSyncSource extends Source {

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
    public void init(SourceConfig sourceConfig, App app) {
        httpApp = (HttpApp) app;
        // register http source
        HttpSyncDispatch httpDispatch = SpringContextUtils.getBean(HttpSyncDispatch.class);
        HttpSourceConfig httpSourceConfig = (HttpSourceConfig) sourceConfig;
        httpDispatch.register(httpSourceConfig.getDomain(), httpSourceConfig.getMethod(), httpApp);
    }

}
