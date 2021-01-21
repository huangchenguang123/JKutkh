package com.sharepower.JKutkh.structure.target;

import com.sharepower.JKutkh.structure.app.App;
import com.sharepower.JKutkh.structure.config.target.HttpTargetConfig;
import com.sharepower.JKutkh.structure.config.target.TargetConfig;

import java.util.Map;
import java.util.Set;

/**
 * @date 2020/12/23
 * @author chenguang
 * @desc http target
 */
public class HttpTarget extends Target {

    /**
     * @date 2021/1/21
     * @author chenguang
     * @desc result fields
     */
    private Set<String> fields;

    /**
     * @date 2021/1/21
     * @author chenguang
     * @desc app
     */
    private App app;

    /**
     * @date 2020/12/23
     * @author chenguang
     * @desc input data and execute
     */
    @Override
    public void execute(Map<String, Object> data) {
        data.keySet().removeIf(key -> !fields.contains(key));
    }

    /**
     * @date 2021/1/21
     * @author chenguang
     * @desc init http target
     */
    @Override
    public void init(TargetConfig targetConfig, App app) {
        // cast type
        HttpTargetConfig httpTargetConfig = (HttpTargetConfig) targetConfig;
        this.fields = httpTargetConfig.getResultConfig().getFields();
        this.app = app;
    }

}
