package com.sharepower.JKutkh.structure.config.target;

import com.sharepower.JKutkh.structure.config.base.Config;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

/**
 * @date 2020/12/23
 * @author chenguang
 * @desc some source need result, this config will filter useless field
 */
@Getter
@Setter
public class ResultConfig extends Config {

    /**
     * @date 2020/12/23
     * @author chenguang
     * @desc result fields
     */
    private Set<String> fields;

}
