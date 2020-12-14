package com.sharepower.JKutkh.app.sync;

import com.sharepower.JKutkh.app.base.App;

import org.apache.http.impl.bootstrap.HttpServer;
import org.apache.http.impl.bootstrap.ServerBootstrap;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import lombok.Getter;
import lombok.SneakyThrows;

@Getter
@Component
public class HttpApp extends App {

    private HttpServer server;

    @Override
    @SneakyThrows
    @PostConstruct
    public void init() {
        // step 1: init source
        this.server = ServerBootstrap.bootstrap()
            .setListenerPort(8081)
            .create();

        server.start();
        System.out.println("HttpSyncSource启动成功！");

        // step 2: init pipeline

        // step 3: init target
    }

}
