package com.sharepower.JKutkh.structure.pipeline;

import com.google.common.collect.Lists;
import com.sharepower.JKutkh.common.dto.ExecuteSystemContext;
import com.sharepower.JKutkh.common.enums.ExecuteEnums;
import com.sharepower.JKutkh.common.utils.SpringContextUtils;
import com.sharepower.JKutkh.structure.app.App;
import com.sharepower.JKutkh.structure.config.pipeline.HandlerConfig;
import com.sharepower.JKutkh.structure.config.pipeline.PipelineConfig;
import com.sharepower.JKutkh.structure.rule.RuleValidate;

import org.apache.commons.collections4.CollectionUtils;
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
     * @date 2020/12/22
     * @author chenguang
     * @desc handler map
     */
    private Map<Long, HandlerWrapper> handlersMap;

    /**
     * @date 2020/12/14
     * @author chenguang
     * @desc input data and execute
     */
    public void execute(Map<String, Object> data) {
        // create map
        handlersMap = handlers.stream().collect(Collectors.toMap(HandlerWrapper::getId, handlers -> handlers));

        // create root handler
        List<HandlerWrapper> rootHandlers = Lists.newArrayList();
        // init context
        for (HandlerWrapper handlerWrapper : handlers) {
            if (CollectionUtils.isEmpty(handlerWrapper.getParent())) {
                rootHandlers.add(handlerWrapper);
            }
            // set context
            ExecuteSystemContext context = (ExecuteSystemContext) data.get(ExecuteSystemContext.class.getSimpleName());
            context.getDagParentMap().put(handlerWrapper.getId(), handlerWrapper.getParent());
            context.getDagChildrenMap().put(handlerWrapper.getId(), handlerWrapper.getChildren());
        }
        // run and callback
        rootHandlers.forEach(handler -> submit(handler, data));
    }

    /**
     * @date 2021/2/7
     * @author chenguang
     * @desc submit one task
     */
    private void submit(HandlerWrapper handler, Map<String, Object> data) {
        app.getExecuteThreadPool().submitListenable(() -> {
            boolean validate = handler.getRuleValidate().execute(data);
            if (BooleanUtils.isNotTrue(validate)) {
                ExecuteSystemContext context = (ExecuteSystemContext) data.get(ExecuteSystemContext.class.getSimpleName());
                context.setExecuteStatus(ExecuteEnums.RULE_VALIDATE_FAIL);
                return handler.getId();
            }
            boolean result = handler.getHandler().run(data);
            // if run error
            if (BooleanUtils.isNotTrue(result)) {
                ExecuteSystemContext context = (ExecuteSystemContext) data.get(ExecuteSystemContext.class.getSimpleName());
                context.setExecuteStatus(ExecuteEnums.FAIL);
            }
            return handler.getId();
        }, o -> {
            Long currentId = (Long) o;
            ExecuteSystemContext context = (ExecuteSystemContext) data.get(ExecuteSystemContext.class.getSimpleName());
            List<Long> children = context.getDagChildrenMap().get(currentId);
            children.forEach(child -> {
                // remove parent
                List<Long> parent = context.getDagParentMap().get(child);
                parent.remove(currentId);
                // when parent is empty, run child
                if (CollectionUtils.isEmpty(parent)) {
                    // submit child
                    submit(handlersMap.get(child), data);
                }
            });
            return currentId;
        });
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
                // init others
                wrapper.setId(handlerConfig.getId());
                wrapper.setParent(handlerConfig.getParent());
                wrapper.setChildren(handlerConfig.getChildren());
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
