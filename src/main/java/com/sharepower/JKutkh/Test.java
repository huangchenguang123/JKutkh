package com.sharepower.JKutkh;

import com.sharepower.JKutkh.app.sync.HttpApp;
import com.sharepower.JKutkh.config.base.AppConfig;
import com.sharepower.JKutkh.config.source.HttpSourceConfig;
import com.sharepower.JKutkh.config.source.SourceConfig;

import org.apache.http.entity.StringEntity;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class Test implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        SourceConfig sourceConfig = HttpSourceConfig.builder().method("test").httpRequestHandler(
            (request, response, context) -> response.setEntity(new StringEntity("hello world"))).build();

        AppConfig appConfig = AppConfig.builder().sourceConfig(sourceConfig).build();

        HttpApp httpApp = new HttpApp();
        httpApp.init(appConfig);
    }

}
