package com.sharepower.JKutkh.common.handler;

import com.sharepower.JKutkh.structure.pipeline.Handler;

import java.util.Map;

/**
 * @date 2021/2/5
 * @author chenguang
 * @desc handler demo
 */
public class TestHandler extends Handler {

    @Override
    protected boolean run(Map<String, Object> data) {
        String a = (String) data.get("a");
        String b = (String) data.get("b");
        data.put(a, b);
        return true;
    }

}
