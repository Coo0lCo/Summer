package scbc.lyj.beans.version2.factory.support;

import scbc.lyj.beans.version2.factory.config.BeanDefinition;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/21
 *      BeanDefinitionRegistry作为bean注册的各种实现类顶层接口
 *      这种抽象方式可以提高注册bean这项业务的拓展力
 */

public interface BeanDefinitionRegistry {
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
