package com.sharepower.JKutkh.app.base;

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
    public void init() {
        // 1.before init, you want to do something
        before();
        // 2.init source
        initSource();
        // 3.init pipeline
        initPipeline();
        // 4.init target
        initTarget();
        // 5.after init, you want to do something
        after();
    }

    /**
     * @date 2020/12/17
     * @author chenguang
     * @desc before init, you want to do something
     */
    public abstract void before();

    /**
     * @date 2020/12/17
     * @author chenguang
     * @desc init source
     */
    public abstract void initSource();

    /**
     * @date 2020/12/17
     * @author chenguang
     * @desc init pipeline
     */
    public abstract void initPipeline();

    /**
     * @date 2020/12/17
     * @author chenguang
     * @desc init target
     */
    public abstract void initTarget();

    /**
     * @date 2020/12/17
     * @author chenguang
     * @desc after init, you want to do something
     */
    public abstract void after();

}
