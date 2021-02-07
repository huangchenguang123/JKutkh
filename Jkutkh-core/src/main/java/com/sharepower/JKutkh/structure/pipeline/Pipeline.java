package com.sharepower.JKutkh.structure.pipeline;

import com.google.common.collect.Lists;
import com.sharepower.JKutkh.common.enums.ExecuteEnums;
import com.sharepower.JKutkh.common.utils.SpringContextUtils;
import com.sharepower.JKutkh.structure.app.App;
import com.sharepower.JKutkh.structure.config.pipeline.HandlerConfig;
import com.sharepower.JKutkh.structure.config.pipeline.PipelineConfig;
import com.sharepower.JKutkh.structure.rule.RuleValidate;

import org.apache.commons.lang3.BooleanUtils;

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
     * @desc app
     */
    private App app;

    /**
     * @date 2020/12/22
     * @author chenguang
     * @desc handler list
     */
    private List<HandlerWrapper> handlers;

    /**
     * @date 2020/12/14
     * @author chenguang
     * @desc input data and execute
     */
    public void execute(Map<String, Object> data) {
        for (HandlerWrapper handlerWrapper : handlers) {
            boolean validate = handlerWrapper.getRuleValidate().execute(data);
            if (BooleanUtils.isNotTrue(validate)) {
                data.put(ExecuteEnums.class.getSimpleName(), ExecuteEnums.RULE_VALIDATE_FAIL);
                break;
            }
            boolean result = handlerWrapper.getHandler().run(data);
            // if run error
            if (BooleanUtils.isNotTrue(result)) {
                data.put(ExecuteEnums.class.getSimpleName(), ExecuteEnums.FAIL);
            }
        }
    }

    /**
     * @date 2020/12/22
     * @author chenguang
     * @desc init pipeline
     */
    public void init(PipelineConfig pipelineConfig, App app) {
        this.handlers = Lists.newArrayList();
        HandlerManager handlerManager = SpringContextUtils.getBean(HandlerManager.class);
        // load handler config
        List<HandlerConfig> handlerConfigs = pipelineConfig.getHandlerConfigs();
        List<HandlerWrapper> subHandlers = handlerConfigs.stream()
            .map(handlerConfig -> {
                HandlerWrapper wrapper = new HandlerWrapper();
                // init handler
                Handler handler = handlerManager.getHandler(handlerConfig.getUrl(), handlerConfig.getClassName());
                wrapper.setHandler(handler);
                // init ruleValidate
                RuleValidate ruleValidate = new RuleValidate();
                ruleValidate.init(handlerConfig.getRuleValidateConfig());
                wrapper.setRuleValidate(ruleValidate);
                return wrapper;
            })
            .collect(Collectors.toList());
        this.handlers.addAll(subHandlers);
        this.app = app;
    }

    /**
     * @date 2021/1/21
     * @author chenguang
     * @desc get pipeline
     */
    public static Pipeline getPipeline(PipelineConfig pipelineConfig, App app) {
        Pipeline pipeline = new Pipeline();
        pipeline.init(pipelineConfig, app);
        return pipeline;
    }

}
