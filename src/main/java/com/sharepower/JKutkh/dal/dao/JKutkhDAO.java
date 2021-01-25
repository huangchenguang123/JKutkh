package com.sharepower.JKutkh.dal.dao;

import com.sharepower.JKutkh.dal.entity.AppEntity;
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
    @Select("select * from app where id > #{id} and is_deleted = 0 limit 10")
    List<AppEntity> getAppList(@Param("id") Long id);

    /**
     * @date 2021/1/25
     * @author chenguang
     * @desc get component
     */
    @Select("select * from component where #{appId} = app_id and is_deleted = 0 limit 1")
    ComponentEntity getComponent(@Param("appId") Long appId);

}
