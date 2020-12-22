package com.sharepower.JKutkh.source.base;

import com.sharepower.JKutkh.app.base.App;
import com.sharepower.JKutkh.config.base.Config;

import java.util.Map;

/**
 * @date 2020/12/14
 * @author chenguang
 * @desc the base of all source
 */
public interface Source {

    /**
     * @date 2020/12/14
     * @author chenguang
     * @desc source will submit input data to pipeline
     */
    void submit();

    /**
     * @date 2020/12/14
     * @author chenguang
     * @desc dispatch will input data to source
     */
    void input(Map<?, ?> data);

    /**
     * @date 2020/12/22
     * @author chenguang
     * @desc init source
     */
    void init(Config config, App app);

}
