package com.sharepower.JKutkh;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.sharepower.JKutkh.common.enums.SourceTypeEnums;
import com.sharepower.JKutkh.common.enums.TargetTypeEnums;
import com.sharepower.JKutkh.structure.app.HttpApp;
import com.sharepower.JKutkh.structure.config.base.AppConfig;
import com.sharepower.JKutkh.structure.config.pipeline.PipelineConfig;
import com.sharepower.JKutkh.structure.config.source.HttpSourceConfig;
import com.sharepower.JKutkh.structure.config.target.HttpTargetConfig;
import com.sharepower.JKutkh.structure.config.target.ResultConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JKutkhApplication {

    public static void main(String[] args) {
        SpringApplication.run(JKutkhApplication.class, args);
        test();
    }

    public static void test() {
        HttpSourceConfig httpSourceConfig = new HttpSourceConfig();
        httpSourceConfig.setSourceType(SourceTypeEnums.HTTP.getType());
        httpSourceConfig.setDomain("domain");
        httpSourceConfig.setMethod("method");

        PipelineConfig pipelineConfig = new PipelineConfig();
        pipelineConfig.setHandlerConfigs(Lists.newArrayList());

        ResultConfig resultConfig = new ResultConfig();
        resultConfig.setFields(Sets.newHashSet("a", "b"));

        HttpTargetConfig httpTargetConfig = new HttpTargetConfig();
        httpTargetConfig.setTargetType(TargetTypeEnums.HTTP.getType());
        httpTargetConfig.setResultConfig(resultConfig);

        AppConfig appConfig = new AppConfig();
        appConfig.setSourceConfig(httpSourceConfig);
        appConfig.setPipelineConfig(pipelineConfig);
        appConfig.setTargetConfig(httpTargetConfig);

        HttpApp httpApp = new HttpApp();
        httpApp.init(appConfig);
    }

}
