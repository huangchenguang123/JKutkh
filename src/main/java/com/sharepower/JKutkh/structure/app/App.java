package com.sharepower.JKutkh.structure.app;

import com.sharepower.JKutkh.common.enums.ExecuteEnums;
import com.sharepower.JKutkh.structure.config.base.Config;
import com.sharepower.JKutkh.structure.pipeline.Pipeline;
import com.sharepower.JKutkh.structure.source.Source;
import com.sharepower.JKutkh.structure.target.Target;

import java.util.Map;

/**
 * @date 2020/12/17
 * @author chenguang
 * @desc one simple business process is a app
 */
public abstract class App {

    /**
     * @date 2020/12/22
     * @author chenguang
     * @desc source
     */
    protected Source source;

    /**
     * @date 2020/12/23
     * @author chenguang
     * @desc pipeline
     */
    protected Pipeline pipeline;

    /**
     * @date 2020/12/23
     * @author chenguang
     * @desc target
     */
    protected Target target;

    /**
     * @date 2020/12/17
     * @author chenguang 
     * @desc process choreography
     */
    public void init(Config config) {
        // before init, you want to do something
        beforeInit(config);
        // init target
        initTarget(config);
        // init pipeline
        initPipeline(config);
        // init source
        initSource(config);
        // after init, you want to do something
        afterInit(config);
    }

    /**
     * @date 2020/12/17
     * @author chenguang
     * @desc before init, you want to do something
     */
    protected void beforeInit(Config config) {
    }

    /**
     * @date 2020/12/17
     * @author chenguang
     * @desc init source
     */
    protected void initSource(Config config) {
    }

    /**
     * @date 2020/12/17
     * @author chenguang
     * @desc init pipeline
     */
    protected void initPipeline(Config config) {
    }

    /**
     * @date 2020/12/17
     * @author chenguang
     * @desc init target
     */
    protected void initTarget(Config config) {
    }

    /**
     * @date 2020/12/17
     * @author chenguang
     * @desc after init, you want to do something
     */
    protected void afterInit(Config config) {
    }

    /**
     * @date 2020/12/23
     * @author chenguang
     * @desc input data and execute
     */
    public Map<String, Object> execute(Map<String, Object> data) {
        // before execute, you want to do something
        beforeExecute(data);
        // pipeline execute
        pipeline.execute(data);
        // target execute
        target.validateAndExecute(data);
        // before execute, you want to do something
        afterExecute(data);
        return data;
    }

    /**
     * @date 2020/12/17
     * @author chenguang
     * @desc before execute, you want to do something
     */
    protected void beforeExecute(Map<String, Object> data) {
    }

    /**
     * @date 2020/12/17
     * @author chenguang
     * @desc after execute, you want to do something
     */
    protected void afterExecute(Map<String, Object> data) {
    }

}
