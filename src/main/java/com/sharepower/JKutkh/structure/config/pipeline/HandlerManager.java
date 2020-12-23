package com.sharepower.JKutkh.structure.config.pipeline;

import com.google.common.collect.Maps;
import com.sharepower.JKutkh.classloader.JkutkhClassLoader;
import com.sharepower.JKutkh.structure.pipeline.Handler;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import lombok.SneakyThrows;

/**
 * @date 2020/12/23
 * @author chenguang
 * @desc manage all handler
 */
@Component
@SuppressWarnings("unchecked")
public class HandlerManager {

    @Resource
    private JkutkhClassLoader jkutkhClassLoader;

    /**
     * @date 2020/12/23
     * @author chenguang
     * @desc map of handler, key is url/className, value is handler
     */
    private Map<String, Handler> handlerMap;

    /**
     * @date 2020/12/23
     * @author chenguang
     * @desc init manager
     */
    @PostConstruct
    public void init() {
        handlerMap = Maps.newConcurrentMap();
    }

    /**
     * @date 2020/12/23
     * @author chenguang
     * @desc get handler from map
     */
    @SneakyThrows
    public Handler getHandler(String url, String className) {
        Handler handler = handlerMap.get(className);
        // load class from url
        if (Objects.isNull(handler)) {
            Class<? extends Handler> clazz = (Class<? extends Handler>) jkutkhClassLoader.loadClass(url, className);
            handler = handlerMap.put(getKey(url, className), clazz.getDeclaredConstructor().newInstance());
        }
        return handler;
    }

    /**
     * @date 2020/12/23
     * @author chenguang
     * @desc get key of map
     */
    private static String getKey(String url, String className) {
        return url.concat("/").concat(className);
    }

}
