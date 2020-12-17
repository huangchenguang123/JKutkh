package com.sharepower.JKutkh.app.sync;

import com.sharepower.JKutkh.app.base.App;
import com.sharepower.JKutkh.common.config.GlobalConfig;

import org.apache.http.impl.bootstrap.HttpServer;
import org.apache.http.impl.bootstrap.ServerBootstrap;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import lombok.Getter;
import lombok.SneakyThrows;

/**
 * @author huangchenguang
 */
@Getter
@Component
public class HttpApp extends App {

    @Resource
    private GlobalConfig globalConfig;

    private HttpServer server;

    @Override
    @SneakyThrows
    public void before() {
        // step 1: http server
        this.server = ServerBootstrap.bootstrap()
            .setListenerPort(globalConfig.getHttpPort())
            .create();

        server.start();
        System.out.println("HttpSyncSource启动成功！");

        // step 2: init pipeline

        // step 3: init target
    }

    @Override
    public void initSource() {

    }

    @Override
    public void initPipeline() {

    }

    @Override
    public void initTarget() {

    }

    @Override
    public void after() {

    }

}
