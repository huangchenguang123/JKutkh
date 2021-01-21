package com.sharepower.JKutkh.structure.source;

import com.sharepower.JKutkh.common.enums.TargetTypeEnums;
import com.sharepower.JKutkh.structure.app.App;
import com.sharepower.JKutkh.structure.config.base.Config;
import com.sharepower.JKutkh.structure.config.source.SourceConfig;

import java.util.Map;

/**
 * @date 2020/12/14
 * @author chenguang
 * @desc the base of all source
 */
public abstract class Source {

    /**
     * @date 2020/12/14
     * @author chenguang
     * @desc input data and execute
     */
    public abstract void execute(Map<String, Object> data);

    /**
     * @date 2020/12/22
     * @author chenguang
     * @desc init source
     */
    public abstract void init(Config config, App app);

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
