package com.sharepower.JKutkh.structure.pipeline;

import com.google.common.collect.Lists;
import com.sharepower.JKutkh.structure.app.base.App;
import com.sharepower.JKutkh.structure.config.base.Config;
import com.sharepower.JKutkh.structure.config.pipeline.HandlerConfig;
import com.sharepower.JKutkh.structure.config.pipeline.PipelineConfig;
import com.sharepower.JKutkh.utils.SpringContextUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @date 2020/12/22
 * @author chenguang
 * @desc pipeline is a assembly line, data from one handler to another handler,
 * and their data has be change
 */
public class Pipeline {

    /**
     * @date 2020/12/22
     * @author chenguang
     * @desc handler list
     */
    private List<Handler> handlers;

    /**
     * @date 2020/12/14
     * @author chenguang
     * @desc input data and execute
     */
    public void execute(Map<String, Object> data) {
        handlers.forEach(handler -> handler.run(data));
    }

    /**
     * @date 2020/12/22
     * @author chenguang
     * @desc init pipeline
     */
    public static Pipeline init(Config config, App app) {
        Pipeline pipeline = new Pipeline();
        pipeline.handlers = Lists.newArrayList();
        HandlerManager handlerManager = SpringContextUtils.getBean(HandlerManager.class);
        PipelineConfig pipelineConfig = (PipelineConfig) config;
        // load handler config
        List<HandlerConfig> handlerConfigs = pipelineConfig.getHandlerConfigs();
        List<Handler> subHandlers = handlerConfigs.stream()
            .map(handlerConfig -> handlerManager.getHandler(handlerConfig.getUrl(), handlerConfig.getClassName()))
            .collect(Collectors.toList());
        pipeline.handlers.addAll(subHandlers);
        return pipeline;
    }

}
