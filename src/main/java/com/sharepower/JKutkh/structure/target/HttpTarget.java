package com.sharepower.JKutkh.structure.target;

import com.google.common.collect.Maps;
import com.sharepower.JKutkh.common.dto.Result;
import com.sharepower.JKutkh.common.enums.ExecuteEnums;
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
     * @desc app
     */
    private App app;

    /**
     * @date 2021/1/21
     * @author chenguang
     * @desc result fields
     */
    private Set<String> fields;

    /**
     * @date 2020/12/23
     * @author chenguang
     * @desc input data and execute
     */
    @Override
    public void execute(Map<String, Object> data) {
        // get execute
        ExecuteEnums execute = (ExecuteEnums) data.get(ExecuteEnums.class.getSimpleName());
        // remove all others fields
        data.keySet().removeIf(key -> !fields.contains(key));
        // copy ref to result
        Map<String, Object> tempData = Maps.newHashMap(data);
        // clear map
        data.clear();
        // put value
        Result<?> r;
        if (execute.getCode().equals(ExecuteEnums.SUCCESS.getCode())) {
            r = Result.success(tempData);
        } else {
            r = Result.fail(tempData, execute);
        }
        data.putAll(r.toMap());
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
