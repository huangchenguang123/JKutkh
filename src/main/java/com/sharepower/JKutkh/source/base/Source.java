package com.sharepower.JKutkh.source.base;

import com.sharepower.JKutkh.app.base.App;
import com.sharepower.JKutkh.config.base.Config;

/**
 * @date 2020/12/14
 * @author chenguang
 * @desc the base of all Source
 */
public interface Source {

    /**
     * @date 2020/12/14
     * @author chenguang
     * @desc Source will submit input data to Pipeline
     */
    void submit();

    void init(Config config, App app);

}
