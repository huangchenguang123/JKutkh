package com.sharepower.JKutkh.common.utils;

import java.lang.reflect.Field;

import lombok.SneakyThrows;

/**
 * @date 2020/12/22
 * @author chenguang
 * @desc class field utils
 */
public class ClassFieldUtils {

    /**
     * @date 2020/12/22
     * @author chenguang
     * @desc get field from some class
     */
    @SneakyThrows
    public static Object getField(Class<?> clazz, String fieldName, Object object) {
        // get field
        Field field = clazz.getDeclaredField(fieldName);
        // set accessible
        field.setAccessible(true);
        // get value
        return field.get(object);
    }

    /**
     * @date 2020/12/22
     * @author chenguang
     * @desc get field to some class
     */
    @SneakyThrows
    public static void setField(Class<?> clazz, String fieldName, Object object, Object value) {
        // get field
        Field field = clazz.getDeclaredField(fieldName);
        // set accessible
        field.setAccessible(true);
        // set value
        field.set(object, value);
    }

}
