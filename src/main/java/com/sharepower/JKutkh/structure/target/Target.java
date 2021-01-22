package com.sharepower.JKutkh.structure.target;

import com.sharepower.JKutkh.common.enums.TargetTypeEnums;
import com.sharepower.JKutkh.structure.app.App;
import com.sharepower.JKutkh.structure.config.target.TargetConfig;
import com.sharepower.JKutkh.structure.rule.RuleValidate;

import java.util.Map;

/**
 * @date 2020/12/23
 * @author chenguang 
 * @desc output data to somewhere
 */
public abstract class Target {

    /**
     * @date 2021/1/21
     * @author chenguang
     * @desc rule validate
     */
    protected RuleValidate ruleValidate;

    /**
     * @date 2020/12/23
     * @author chenguang 
     * @desc input data and execute
     */
    public abstract void execute(Map<String, Object> data);

    /**
     * @date 2020/12/22
     * @author chenguang
     * @desc init target
     */
    public abstract void init(TargetConfig targetConfig, App app);

    /**
     * @date 2020/12/23
     * @author chenguang
     * @desc get target type by config
     */
    public static Target getTarget(TargetConfig targetConfig, App app) {
        String targetType = targetConfig.getTargetType();
        if (TargetTypeEnums.HTTP.getType().equals(targetType)) {
            HttpTarget httpTarget = new HttpTarget();
            httpTarget.init(targetConfig, app);
            return httpTarget;
        }
        return null;
    }

}
