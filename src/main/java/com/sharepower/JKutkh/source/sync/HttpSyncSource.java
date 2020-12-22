package com.sharepower.JKutkh.source.sync;

import com.sharepower.JKutkh.app.base.App;
import com.sharepower.JKutkh.app.sync.HttpApp;
import com.sharepower.JKutkh.common.utils.ClassFieldUtils;
import com.sharepower.JKutkh.config.base.Config;
import com.sharepower.JKutkh.config.source.HttpSourceConfig;
import com.sharepower.JKutkh.source.base.Source;

import lombok.SneakyThrows;
import org.apache.http.impl.bootstrap.HttpServer;
import org.apache.http.protocol.HttpService;
import org.apache.http.protocol.UriHttpRequestHandlerMapper;

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
     * @date 2020/12/22
     * @author chenguang
     * @desc source will submit input data to pipeline
     */
    @Override
    public void submit() {
    }

    /**
     * @date 2020/12/22
     * @author chenguang
     * @desc init http source
     */
    @Override
    @SneakyThrows
    public void init(Config config, App app) {
        // init property
        httpApp = (HttpApp) app;
        // int http method
        HttpSourceConfig httpSourceConfig = (HttpSourceConfig) config;
        HttpServer httpServer = httpApp.getServer();
        // init http handler
        HttpService httpService = (HttpService) ClassFieldUtils.getField(HttpServer.class, "httpService", httpServer);
        UriHttpRequestHandlerMapper handlerMapper = (UriHttpRequestHandlerMapper) ClassFieldUtils.getField(HttpService.class, "handlerMapper", httpService);
        handlerMapper.register(httpSourceConfig.getMethod(), httpSourceConfig.getHttpRequestHandler());
        ClassFieldUtils.setField(HttpService.class, "handlerMapper", httpService, handlerMapper);
    }

}
