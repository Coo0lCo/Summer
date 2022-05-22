package scbc.lyj.beans.support;


import scbc.lyj.beans.config.BeanDefinition;

/**
 * @author SCBC_LiYongJie
 * {@code @Date} 2022/5/22
 */
public interface BeanDefinitionRegistry {
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
