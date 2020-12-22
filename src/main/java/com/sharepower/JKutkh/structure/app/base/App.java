package com.sharepower.JKutkh.structure.app.base;

import com.sharepower.JKutkh.structure.config.base.Config;

/**
 * @date 2020/12/17
 * @author chenguang
 * @desc one simple business process is a app
 */
public abstract class App {

    /**
     * @date 2020/12/17
     * @author chenguang 
     * @desc process choreography
     */
    public void init(Config config) {
        // before init, you want to do something
        before(config);
        // init target
        initTarget(config);
        // init pipeline
        initPipeline(config);
        // init source
        initSource(config);
        // after init, you want to do something
        after(config);
    }

    /**
     * @date 2020/12/17
     * @author chenguang
     * @desc before init, you want to do something
     */
    protected void before(Config config) {
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
    protected void after(Config config) {
    }

}
