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

    HTTP("http"),
    ;

    /**
     * @date 2020/12/23
     * @author chenguang
     * @desc type
     */
    private String type;

}
