package com.sharepower.JKutkh.source.sync;

import com.sharepower.JKutkh.app.sync.HttpApp;
import com.sharepower.JKutkh.config.base.Config;
import com.sharepower.JKutkh.config.source.HttpSourceConfig;
import com.sharepower.JKutkh.source.base.Source;
import com.sharepower.JKutkh.utils.SpringContextUtil;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.SneakyThrows;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.bootstrap.HttpServer;
import org.apache.http.impl.bootstrap.ServerBootstrap;
import org.apache.http.protocol.HttpRequestHandlerMapper;
import org.apache.http.protocol.UriHttpRequestHandlerMapper;

import java.lang.reflect.Field;

/**
 * @date 2020/12/14
 * @author chenguang
 * @desc http source
 *
 * all http request will input into this Source
 */
@Builder
@AllArgsConstructor
public class HttpSyncSource implements Source {

    private final String path;

    private final int port;

    @SneakyThrows
    public void start(Config config) {
//        HttpApp httpApp = (HttpApp) SpringContextUtil.getBean("httpApp");
//        HttpServer httpServer = httpApp.getServer();
//        Class clazz = HttpServer.class;
//        Field field = clazz.getDeclaredField("handlerMapper");
//        field.setAccessible(true);
//        UriHttpRequestHandlerMapper handlerMapper = (UriHttpRequestHandlerMapper) field.get(httpServer);
//        handlerMapper.register();
//        field.set();
    }

    @Override
    public void submit() {
    }

}
