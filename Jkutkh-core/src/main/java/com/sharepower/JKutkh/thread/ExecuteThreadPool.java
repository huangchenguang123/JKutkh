package com.sharepower.JKutkh.thread;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import org.springframework.stereotype.Component;

import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import lombok.extern.slf4j.Slf4j;

/**
 * @date 2021/2/7
 * @author chenguang
 * @desc execute thread pool
 */
@Slf4j
@Component
public class ExecuteThreadPool {

    /**
     * @date 2021/2/7
     * @author chenguang
     * @desc default thread pool
     */
    private final ListeningExecutorService threadPoolExecutor = MoreExecutors.listeningDecorator(new ThreadPoolExecutor(36,
                                                                                                                        64,
                                                                                                                        60L,
                                                                                                                        TimeUnit.SECONDS,
                                                                                                                        new LinkedBlockingQueue<Runnable>(100000),
                                                                                                                        new ThreadFactoryBuilder().setNameFormat("threadPoolExecutor-%d").build(),
                                                                                                                        new ThreadPoolExecutor.CallerRunsPolicy()));

    /**
     * @date 2021/2/7
     * @author chenguang
     * @desc submit listenable callable
     */
    public <T, R> void submitListenable(Callable<?> callable, Function<Object, Object> function) {
        ListenableFuture<?> listenableFuture = threadPoolExecutor.submit(callable);
        Runnable runnable = () -> {
            try {
                function.apply(listenableFuture.get());
            } catch (Exception e) {
                log.error("listenableFuture run error", e);
            }
        };
        listenableFuture.addListener(runnable, threadPoolExecutor);
    }

}
