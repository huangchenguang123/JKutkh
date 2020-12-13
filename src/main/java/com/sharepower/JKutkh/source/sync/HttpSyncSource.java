package com.sharepower.JKutkh.source.sync;

import com.sharepower.JKutkh.source.parent.ASyncSource;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.SneakyThrows;
import org.apache.http.*;
import org.apache.http.config.SocketConfig;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.bootstrap.HttpServer;
import org.apache.http.impl.bootstrap.ServerBootstrap;

import java.util.concurrent.TimeUnit;

@Builder
@AllArgsConstructor
public class HttpSyncSource implements ASyncSource {

    private String path;

    private int port;

    @SneakyThrows
    public void start() {
        SocketConfig socketConfig = SocketConfig.custom()
                .build();

        HttpServer server = ServerBootstrap.bootstrap()
                .setListenerPort(port)
                .setServerInfo("Test/1.1")
                .setSocketConfig(socketConfig)
                .setExceptionLogger(ExceptionLogger.STD_ERR)
                .registerHandler(path, (request, response, context) -> {
                    StringEntity entity = new StringEntity("hello world", ContentType.create("application/json", "UTF-8"));
                    response.setEntity(entity);
                })
                .create();

        server.start();
        System.out.println("启动成功！");
        server.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> server.shutdown(5, TimeUnit.SECONDS)));
    }

    public static void main(String[] args) {
        HttpSyncSource httpSyncSource = new HttpSyncSource("/test", 8080);
        httpSyncSource.start();
    }

}
