package com.sharepower.JKutkh.config.source;

import org.apache.http.protocol.HttpRequestHandler;

import lombok.Getter;
import lombok.Setter;

/**
 * @date 2020/12/14
 * @author chenguang
 * @desc http Source config
 */
@Getter
@Setter
public class HttpSourceConfig extends SourceConfig {

    private String method;

    private HttpRequestHandler httpRequestHandler;

}
