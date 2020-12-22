package com.sharepower.JKutkh.config.source;

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
     * @desc http domain name
     */
    private String domain;

    /**
     * @date 2020/12/22
     * @author chenguang
     * @desc http method name
     */
    private String method;

}
