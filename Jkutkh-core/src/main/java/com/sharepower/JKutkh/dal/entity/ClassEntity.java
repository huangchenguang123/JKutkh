package com.sharepower.JKutkh.dal.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @date 2021/1/25
 * @author chenguang
 * @desc class entity
 */
@Getter
@Setter
public class ClassEntity {

    /**
     * @date 2021/2/7
     * @author chenguang
     * @desc id
     */
    private Long id;

    /**
     * @date 2021/2/7
     * @author chenguang
     * @desc class url
     */
    private String url;

    /**
     * @date 2021/2/7
     * @author chenguang
     * @desc class name
     */
    private String className;

    /**
     * @date 2021/2/7
     * @author chenguang
     * @desc delete mark
     */
    private String introduction;

    /**
     * @date 2021/2/7
     * @author chenguang
     * @desc delete mark
     */
    private Integer isDeleted;

}
