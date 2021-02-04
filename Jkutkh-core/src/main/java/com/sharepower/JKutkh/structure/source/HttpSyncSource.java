package com.sharepower.JKutkh.structure.source;

import com.sharepower.JKutkh.common.utils.SpringContextUtils;
import com.sharepower.JKutkh.dispatch.HttpSyncDispatch;
import com.sharepower.JKutkh.structure.app.App;
import com.sharepower.JKutkh.structure.config.source.HttpSourceConfig;
import com.sharepower.JKutkh.structure.config.source.SourceConfig;

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
     * @desc app
     */
    private App app;

    /**
     * @date 2020/12/22
     * @author chenguang
     * @desc init http source
     */
    @Override
    @SneakyThrows
    public void init(SourceConfig sourceConfig, App app) {
        // register http source
        HttpSyncDispatch httpDispatch = SpringContextUtils.getBean(HttpSyncDispatch.class);
        HttpSourceConfig httpSourceConfig = (HttpSourceConfig) sourceConfig;
        httpDispatch.register(httpSourceConfig.getDomain(), httpSourceConfig.getMethod(), app);
    }

}
