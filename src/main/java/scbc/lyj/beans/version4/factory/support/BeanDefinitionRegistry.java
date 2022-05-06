package scbc.lyj.beans.version4.factory.support;

import scbc.lyj.beans.version4.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
