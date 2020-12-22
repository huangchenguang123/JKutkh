package com.sharepower.JKutkh.dispatch;

import com.google.common.collect.Maps;
import com.sharepower.JKutkh.source.base.Source;

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
public class HttpDispatch {

    /**
     * @date 2020/12/22
     * @author chenguang
     * @desc this table can choose source by url
     */
    private final Map<String, Source> httpRulerMatcherTable = Maps.newConcurrentMap();

    /**
     * @date 2020/12/22
     * @author chenguang
     * @desc all http will use this method, this method will choose how to run
     */
    @RequestMapping("/{domain}/{method}")
    public String input(@PathVariable("domain") String domain, @PathVariable("method") String method, @RequestBody Map<?, ?> data) {
        Source source = httpRulerMatcherTable.get(getKey(domain, method));
        source.input(data);
        return getKey(domain, method).concat(" is invoke success, data=").concat(String.valueOf(data));
    }

    /**
     * @date 2020/12/22
     * @author chenguang
     * @desc register ruler matcher table
     */
    public void register(String domain, String method, Source source) {
        httpRulerMatcherTable.put(getKey(domain, method), source);
    }

    /**
     * @date 2020/12/22
     * @author chenguang
     * @desc build key
     */
    private String getKey(String domain, String method) {
        return domain.concat("/").concat(method);
    }

}
