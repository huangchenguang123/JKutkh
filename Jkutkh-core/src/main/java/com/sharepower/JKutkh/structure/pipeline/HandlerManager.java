package com.sharepower.JKutkh.structure.pipeline;

import com.google.common.collect.Maps;
import com.sharepower.JKutkh.classloader.JkutkhClassLoader;

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
    @SuppressWarnings("unchecked")
    public Handler getHandler(String url, String className) {
        Handler handler = handlerMap.get(className);
        // load class from url
        if (Objects.isNull(handler)) {
            Class<? extends Handler> clazz = (Class<? extends Handler>) jkutkhClassLoader.loadClass(url, className);
            Handler newHandler = clazz.getDeclaredConstructor().newInstance();
            handlerMap.put(className, newHandler);
            handler = newHandler;
        }
        return handler;
    }

}
