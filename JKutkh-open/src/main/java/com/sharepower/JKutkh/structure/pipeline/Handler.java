package com.sharepower.JKutkh.structure.pipeline;

import java.util.Map;

import lombok.Getter;

/**
 * @date 2020/12/22
 * @author chenguang
 * @desc one block of pipeline
 */
@Getter
public abstract class Handler {

    /**
     * @date 2020/12/22
     * @author chenguang
     * @desc business logic
     */
    protected abstract boolean run(Map<String, Object> data);

}
