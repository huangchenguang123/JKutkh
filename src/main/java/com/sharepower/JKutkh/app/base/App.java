package com.sharepower.JKutkh.app.base;

import com.sharepower.JKutkh.config.base.Config;

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
        // 1.before init, you want to do something
        before(config);
        // 2.init target
        initTarget(config);
        // 3.init pipeline
        initPipeline(config);
        // 4.init source
        initSource(config);
        // 5.after init, you want to do something
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
