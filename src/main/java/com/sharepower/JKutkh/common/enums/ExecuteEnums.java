package com.sharepower.JKutkh.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @date 2021/1/21
 * @author chenguang
 * @desc execute status
 */
@Getter
@AllArgsConstructor
public enum ExecuteEnums {

    /**
     * @date 2021/1/21
     * @author chenguang
     * @desc execute success
     */
    SUCCESS(200, "success"),

    /**
     * @date 2021/1/21
     * @author chenguang
     * @desc JKutkh run error
     */
    SYSTEM_ERROR(400, "system error"),

    /**
     * @date 2021/1/21
     * @author chenguang
     * @desc execute fail
     */
    FAIL(500, "fail"),
    ;

    /**
     * @date 2021/1/21
     * @author chenguang
     * @desc execute code
     */
    private final Integer code;

    /**
     * @date 2021/1/21
     * @author chenguang
     * @desc execute message
     */
    private final String message;

}
