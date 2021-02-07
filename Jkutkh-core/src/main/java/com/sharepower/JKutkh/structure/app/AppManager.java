package com.sharepower.JKutkh.structure.app;

import com.alibaba.fastjson.JSON;
import com.sharepower.JKutkh.common.enums.SourceTypeEnums;
import com.sharepower.JKutkh.common.enums.TargetTypeEnums;
import com.sharepower.JKutkh.dal.dao.JKutkhDAO;
import com.sharepower.JKutkh.dal.entity.AppEntity;
import com.sharepower.JKutkh.dal.entity.ClassEntity;
import com.sharepower.JKutkh.dal.entity.ComponentEntity;
import com.sharepower.JKutkh.structure.config.base.AppConfig;
import com.sharepower.JKutkh.structure.config.pipeline.HandlerConfig;
import com.sharepower.JKutkh.structure.config.pipeline.PipelineConfig;
import com.sharepower.JKutkh.structure.config.source.HttpSourceConfig;
import com.sharepower.JKutkh.structure.config.source.SourceConfig;
import com.sharepower.JKutkh.structure.config.target.HttpTargetConfig;
import com.sharepower.JKutkh.structure.config.target.TargetConfig;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Component;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @date 2021/1/25
 * @author chenguang
 * @desc app manager will init all app
 */
@Component
public class AppManager {

    @Resource
    private JKutkhDAO jKutkhDAO;

    /**
     * @date 2021/1/25
     * @author chenguang
     * @desc init all app
     */
    @PostConstruct
    private void init() {
        long pageSize = 10L;
        List<AppEntity> appList;
        do {
            appList = jKutkhDAO.getAppList(NumberUtils.LONG_ZERO, pageSize);
            appList.forEach(appEntity -> {
                ComponentEntity componentEntity = jKutkhDAO.getComponent(appEntity.getId());
                // init appConfig
                AppConfig appConfig = new AppConfig();
                // init sourceConfig
                String sourceConfigStr = componentEntity.getSourceConfig();
                SourceConfig sourceConfig = JSON.parseObject(sourceConfigStr, SourceConfig.class);
                appConfig.setSourceConfig(chooseSourceConfig(sourceConfig, sourceConfigStr));
                // init pipeLineConfig
                String pipeLineConfigStr = componentEntity.getPipelineConfig();
                PipelineConfig pipelineConfig = JSON.parseObject(pipeLineConfigStr, PipelineConfig.class);
                appConfig.setPipelineConfig(parsePipeline(pipelineConfig));
                // init targetConfig
                String targetConfigStr = componentEntity.getTargetConfig();
                TargetConfig targetConfig = JSON.parseObject(targetConfigStr, TargetConfig.class);
                appConfig.setTargetConfig(chooseTargetConfig(targetConfig, targetConfigStr));
                // init app
                initApp(appConfig);
            });
        } while (appList.size() == pageSize);
    }
    
    /**
     * @date 2021/1/25
     * @author chenguang 
     * @desc choose source config type
     */
    private SourceConfig chooseSourceConfig(SourceConfig sourceConfig, String sourceConfigStr) {
        if (SourceTypeEnums.HTTP.getType().equals(sourceConfig.getSourceType())) {
            return JSON.parseObject(sourceConfigStr, HttpSourceConfig.class);
        }
        return null;
    }

    /**
     * @date 2021/1/25
     * @author chenguang
     * @desc choose target config type
     */
    private TargetConfig chooseTargetConfig(TargetConfig targetConfig, String targetConfigStr) {
        if (TargetTypeEnums.HTTP.getType().equals(targetConfig.getTargetType())) {
            return JSON.parseObject(targetConfigStr, HttpTargetConfig.class);
        }
        return null;
    }

    /**
     * @date 2021/1/25
     * @author chenguang
     * @desc init app
     */
    private void initApp(AppConfig appConfig) {
        SourceConfig sourceConfig = appConfig.getSourceConfig();
        if (SourceTypeEnums.HTTP.getType().equals(sourceConfig.getSourceType())) {
            App app = new HttpApp();
            app.init(appConfig);
        }
    }

    /**
     * @date 2021/2/7
     * @author chenguang
     * @desc parse class to handler config
     */
    private PipelineConfig parsePipeline(PipelineConfig pipelineConfig) {
        for (HandlerConfig handlerConfig : pipelineConfig.getHandlerConfigs()) {
            ClassEntity classEntity = jKutkhDAO.getClass(handlerConfig.getClassId());
            handlerConfig.setUrl(classEntity.getUrl());
            handlerConfig.setClassName(classEntity.getClassName());
        }
        return pipelineConfig;
    }

}
