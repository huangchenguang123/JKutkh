package com.sharepower.JKutkh.structure.source.base;

import com.sharepower.JKutkh.structure.app.base.App;
import com.sharepower.JKutkh.structure.config.base.Config;

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
     * @desc input data and execute
     */
    void execute(Map<String, Object> data);

    /**
     * @date 2020/12/22
     * @author chenguang
     * @desc init source
     */
    void init(Config config, App app);

}
