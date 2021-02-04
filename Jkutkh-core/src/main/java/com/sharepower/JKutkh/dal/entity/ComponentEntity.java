package com.sharepower.JKutkh.dal.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @date 2021/1/25
 * @author chenguang
 * @desc component entity
 */
@Getter
@Setter
public class ComponentEntity {

    /**
     * @date 2021/1/25
     * @author chenguang
     * @desc id
     */
    private Long id;

    /**
     * @date 2021/1/25
     * @author chenguang
     * @desc source config
     */
    private String sourceConfig;

    /**
     * @date 2021/1/25
     * @author chenguang
     * @desc pipeline config
     */
    private String pipelineConfig;

    /**
     * @date 2021/1/25
     * @author chenguang
     * @desc target config
     */
    private String targetConfig;

    /**
     * @date 2021/1/25
     * @author chenguang
     * @desc app id
     */
    private Long appId;

}
