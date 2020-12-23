package com.sharepower.JKutkh.dispatch.sync;

import com.google.common.collect.Maps;
import com.sharepower.JKutkh.structure.app.base.App;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @date 2020/12/22
 * @author chenguang
 * @desc http dispatch
 */
@RestController
public class HttpSyncDispatch {

    /**
     * @date 2020/12/22
     * @author chenguang
     * @desc this table can choose app by url
     */
    private final Map<String, App> httpRulerMatcherTable = Maps.newConcurrentMap();

    /**
     * @date 2020/12/22
     * @author chenguang
     * @desc all http will use this method, this method will choose how to run
     */
    @RequestMapping("/{domain}/{method}")
    public Map<String, Object> input(@PathVariable("domain") String domain, @PathVariable("method") String method, @RequestBody Map<String, Object> data) {
        App app = httpRulerMatcherTable.get(getKey(domain, method));
        return app.execute(data);
    }

    /**
     * @date 2020/12/22
     * @author chenguang
     * @desc register ruler matcher table
     */
    public void register(String domain, String method, App app) {
        httpRulerMatcherTable.put(getKey(domain, method), app);
    }

    /**
     * @date 2020/12/22
     * @author chenguang
     * @desc build key
     */
    private static String getKey(String domain, String method) {
        return domain.concat("/").concat(method);
    }

}
