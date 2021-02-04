package com.sharepower.JKutkh.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @date 2020/12/22
 * @author chenguang
 * @desc some utils about spring context
 */
@Component
public class SpringContextUtils implements ApplicationContextAware {

    /**
     * @date 2020/12/22
     * @author chenguang
     * @desc spring application context
     */
    private static ApplicationContext applicationContext;

    /**
     * @date 2020/12/22
     * @author chenguang
     * @desc set application context
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtils.applicationContext = applicationContext;
    }

    /**
     * @date 2020/12/22
     * @author chenguang
     * @desc get application context
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * @date 2020/12/22
     * @author chenguang
     * @desc get bean by class
     */
    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

}