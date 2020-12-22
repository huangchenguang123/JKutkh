package com.sharepower.JKutkh.config.source;

import org.apache.http.protocol.HttpRequestHandler;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @date 2020/12/14
 * @author chenguang
 * @desc http source config
 */
@Getter
@Setter
@Builder
public class HttpSourceConfig extends SourceConfig {

    /**
     * @date 2020/12/22
     * @author chenguang
     * @desc http method name
     */
    private String method;

    /**
     * @date 2020/12/22
     * @author chenguang
     * @desc http method handler
     */
    private HttpRequestHandler httpRequestHandler;

}
