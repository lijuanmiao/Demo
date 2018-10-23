package cn.no7player.service;

import cn.no7player.model.PointDomain;

/**规则接口
 * Created by lijm on 2017-10-23.
 */
public interface PointRuleEngine {

    /**
     * 初始化规则引擎
     */
    public void initEngine();

    /**
     * 刷新规则引擎中的规则
     */
    public void  refresEnginRule();

    /**
     * 执行规则引擎
     * @param pointDomain
     */
    public void executeEngine(final PointDomain pointDomain);
}
