package com.sharepower.JKutkh.dal.dao;

import com.sharepower.JKutkh.dal.entity.AppEntity;
import com.sharepower.JKutkh.dal.entity.ClassEntity;
import com.sharepower.JKutkh.dal.entity.ComponentEntity;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @date 2021/1/25
 * @author chenguang
 * @desc some db opt of JKutkh
 */
public interface JKutkhDAO {

    /**
     * @date 2021/1/25
     * @author chenguang
     * @desc get app list
     */
    @Select("select * from app where id > #{id} and is_deleted = 0 limit #{pageSize}")
    List<AppEntity> getAppList(@Param("id") Long id, @Param("pageSize") Long pageSize);

    /**
     * @date 2021/1/25
     * @author chenguang
     * @desc get component
     */
    @Select("select * from component where app_id = #{appId} and is_deleted = 0 limit 1")
    ComponentEntity getComponent(@Param("appId") Long appId);

    /**
     * @date 2021/1/25
     * @author chenguang
     * @desc get component
     */
    @Select("select * from classes where id = #{classId} and is_deleted = 0 limit 1")
    ClassEntity getClass(@Param("classId") Long classId);

}
