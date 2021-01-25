package com.sharepower.JKutkh.dal.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @date 2021/1/25
 * @author chenguang
 * @desc app entity
 */
@Getter
@Setter
public class AppEntity {

    /**
     * @date 2021/1/25
     * @author chenguang
     * @desc id
     */
    private Long id;

    /**
     * @date 2021/1/25
     * @author chenguang
     * @desc app name
     */
    private String appName;

    /**
     * @date 2021/1/25
     * @author chenguang
     * @desc app introduction
     */
    private String appIntroduction;

    /**
     * @date 2021/1/25
     * @author chenguang
     * @desc delete mark
     */
    private Integer isDeleted;

}
