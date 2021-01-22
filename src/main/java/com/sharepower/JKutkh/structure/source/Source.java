package com.sharepower.JKutkh.structure.source;

import com.sharepower.JKutkh.common.enums.TargetTypeEnums;
import com.sharepower.JKutkh.structure.app.App;
import com.sharepower.JKutkh.structure.config.source.SourceConfig;
import com.sharepower.JKutkh.structure.rule.RuleValidate;

/**
 * @date 2020/12/14
 * @author chenguang
 * @desc the base of all source
 */
public abstract class Source {

    /**
     * @date 2021/1/21
     * @author chenguang
     * @desc rule validate
     */
    protected RuleValidate ruleValidate;

    /**
     * @date 2020/12/22
     * @author chenguang
     * @desc init source
     */
    public abstract void init(SourceConfig sourceConfig, App app);

    /**
     * @date 2020/12/23
     * @author chenguang
     * @desc get source type by config
     */
    public static Source getSource(SourceConfig sourceConfig, App app) {
        String sourceType = sourceConfig.getSourceType();
        if (TargetTypeEnums.HTTP.getType().equals(sourceType)) {
            HttpSyncSource httpSyncSource = new HttpSyncSource();
            httpSyncSource.init(sourceConfig, app);
            return httpSyncSource;
        }
        return null;
    }

}
