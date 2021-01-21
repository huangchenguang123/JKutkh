package com.sharepower.JKutkh.common.dto;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.sharepower.JKutkh.common.enums.ExecuteEnums;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;

/**
 * @date 2021/1/21
 * @author chenguang
 * @desc result
 */
@Getter
@Setter
public class Result<T> {

    /**
     * @date 2021/1/21
     * @author chenguang
     * @desc result of code
     */
    private Integer code;

    /**
     * @date 2021/1/21
     * @author chenguang
     * @desc result of message
     */
    private String message;

    /**
     * @date 2021/1/21
     * @author chenguang
     * @desc result of data
     */
    private T data;

    /**
     * @date 2021/1/21
     * @author chenguang
     * @desc build success result
     */
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.code = ExecuteEnums.SUCCESS.getCode();
        result.message = ExecuteEnums.SUCCESS.getMessage();
        result.data = data;
        return result;
    }

    /**
     * @date 2021/1/21
     * @author chenguang
     * @desc build fail result
     */
    public static <T> Result<T> fail(T data, ExecuteEnums enums) {
        Result<T> result = new Result<>();
        result.code = enums.getCode();
        result.message = enums.getMessage();
        result.data = data;
        return result;
    }

    /**
     * @date 2021/1/21
     * @author chenguang
     * @desc object to map
     */
    public Map<String, Object> toMap() {
        return JSON.parseObject(JSON.toJSONString(this), new TypeReference<>() {});
    }

}
