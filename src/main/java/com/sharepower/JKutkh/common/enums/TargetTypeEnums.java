package com.sharepower.JKutkh.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @date 2020/12/23
 * @author chenguang
 * @desc target type enums
 */
@Getter
@AllArgsConstructor
public enum TargetTypeEnums {

    /**
     * @date 2021/1/21
     * @author chenguang
     * @desc http target
     */
    HTTP("http"),
    ;

    /**
     * @date 2020/12/23
     * @author chenguang
     * @desc type
     */
    private final String type;

}
