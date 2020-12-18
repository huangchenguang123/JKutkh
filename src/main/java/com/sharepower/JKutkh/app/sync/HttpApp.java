package com.sharepower.JKutkh.app.sync;

import com.sharepower.JKutkh.app.base.App;
import com.sharepower.JKutkh.common.config.GlobalConfig;
import com.sharepower.JKutkh.config.base.AppConfig;
import com.sharepower.JKutkh.config.base.Config;
import com.sharepower.JKutkh.source.base.Source;
import com.sharepower.JKutkh.source.sync.HttpSyncSource;

import org.apache.http.impl.bootstrap.HttpServer;
import org.apache.http.impl.bootstrap.ServerBootstrap;

import javax.annotation.Resource;

import lombok.Getter;
import lombok.SneakyThrows;


/**
 * @date 2020/12/18
 * @author chenguang
 * @desc http server app
 */
@Getter
public class HttpApp extends App {

    @Resource
    private GlobalConfig globalConfig;

    private Source source;

    private HttpServer server;

    @Override
    @SneakyThrows
    public void before(Config config) {
        // http server start
        this.server = ServerBootstrap.bootstrap()
            .setListenerPort(globalConfig.getHttpPort())
            .create();

        server.start();
    }

    @Override
    protected void initSource(Config config) {
        // cast type
        AppConfig appConfig = (AppConfig) config;
        // init source
        Source source = new HttpSyncSource();
        source.init(appConfig, this);
        this.source = source;
    }

    @Override
    protected void initPipeline(Config config) {
    }

    @Override
    protected void initTarget(Config config) {
    }

    @Override
    protected void after(Config config) {
    }

}
