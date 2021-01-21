package com.sharepower.JKutkh.structure.pipeline;

import java.util.Map;

/**
 * @date 2020/12/22
 * @author chenguang
 * @desc one block of pipeline
 */
public interface Handler {

    /**
     * @date 2020/12/22
     * @author chenguang
     * @desc business logic
     */
    boolean run(Map<String, Object> data);

}
