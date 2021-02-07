package com.sharepower.JKutkh.common.dto;

import com.sharepower.JKutkh.common.enums.ExecuteEnums;

import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

/**
 * @date 2021/2/7
 * @author chenguang
 * @desc execute system context
 */
@Getter
@Setter
public class ExecuteSystemContext {

    /**
     * @date 2021/2/7
     * @author chenguang
     * @desc rum status
     */
    private ExecuteEnums executeStatus;

    /**
     * @date 2021/2/7
     * @author chenguang
     * @desc current node's not ready parent
     */
    private Map<Long, List<Long>> dagParentMap;

    /**
     * @date 2021/2/7
     * @author chenguang
     * @desc current node's not run children
     */
    private Map<Long, List<Long>> dagChildrenMap;

}
