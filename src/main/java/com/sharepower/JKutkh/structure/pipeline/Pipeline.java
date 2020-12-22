package com.sharepower.JKutkh.structure.pipeline;

import com.google.common.collect.Lists;
import com.sharepower.JKutkh.structure.app.base.App;
import com.sharepower.JKutkh.structure.config.base.Config;

import java.util.List;
import java.util.Map;

/**
 * @date 2020/12/22
 * @author chenguang
 * @desc pipeline is a assembly line, data from one handler to another handler,
 * and their data has be change
 */
public class Pipeline {

    /**
     * @date 2020/12/22
     * @author chenguang
     * @desc handler list
     */
    private List<Handler> handlers;

    /**
     * @date 2020/12/14
     * @author chenguang
     * @desc data will input pipeline and will be change
     */
    void input(Map<?, ?> data) {
        handlers.forEach(handler -> handler.run(data));
    }

    /**
     * @date 2020/12/22
     * @author chenguang
     * @desc init pipeline
     */
    void init(Config config, App app) {
        handlers = Lists.newArrayList();
    }

}
