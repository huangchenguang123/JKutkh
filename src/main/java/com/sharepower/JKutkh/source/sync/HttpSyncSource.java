package com.sharepower.JKutkh.source.sync;

import com.sharepower.JKutkh.app.base.App;
import com.sharepower.JKutkh.app.sync.HttpApp;
import com.sharepower.JKutkh.config.base.Config;
import com.sharepower.JKutkh.config.source.HttpSourceConfig;
import com.sharepower.JKutkh.source.base.Source;

import lombok.SneakyThrows;
import org.apache.http.impl.bootstrap.HttpServer;
import org.apache.http.protocol.UriHttpRequestHandlerMapper;

import java.lang.reflect.Field;

/**
 * @date 2020/12/14
 * @author chenguang
 * @desc http source
 *
 * all http request will input into this Source
 */
public class HttpSyncSource implements Source {

    private HttpApp httpApp;

    @Override
    @SneakyThrows
    public void init(Config config, App app) {
        // init property
        httpApp = (HttpApp) app;
        // int http method
        HttpSourceConfig httpSourceConfig = (HttpSourceConfig) config;
        HttpServer httpServer = httpApp.getServer();

        Class<?> clazz = HttpServer.class;
        Field field = clazz.getDeclaredField("handlerMapper");
        field.setAccessible(true);
        UriHttpRequestHandlerMapper handlerMapper = (UriHttpRequestHandlerMapper) field.get(httpServer);
        handlerMapper.register(httpSourceConfig.getMethod(), httpSourceConfig.getHttpRequestHandler());
        field.set(httpServer, handlerMapper);
    }

    @Override
    public void submit() {
    }

}
