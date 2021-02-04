package com.sharepower.JKutkh.structure.rule;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import com.sharepower.JKutkh.structure.config.rule.RuleValidateConfig;

import java.util.Map;

import lombok.SneakyThrows;

/**
 * @date 2021/1/21
 * @author chenguang
 * @desc rule validate
 */
public class RuleValidate {

    /**
     * @date 2021/1/21
     * @author chenguang
     * @desc qlExpress
     *
     * https://github.com/alibaba/QLExpress
     */
    private String qlExpress;

    /**
     * @date 2021/1/21
     * @author chenguang
     * @desc runner
     */
    private ExpressRunner runner;

    /**
     * @date 2021/1/21
     * @author chenguang
     * @desc init rule validate
     */
    public void init(RuleValidateConfig ruleValidateConfig) {
        qlExpress = ruleValidateConfig.getQlExpress();
        runner = new ExpressRunner();
    }

    /**
     * @date 2021/1/21
     * @author chenguang
     * @desc execute qlExpress
     */
    @SneakyThrows
    public boolean execute(Map<String, Object> data) {
        DefaultContext<String, Object> context = new DefaultContext<>();
        context.putAll(data);
        Object r = runner.execute(qlExpress, context, null, true, false);
        return (boolean) r;
    }

}
