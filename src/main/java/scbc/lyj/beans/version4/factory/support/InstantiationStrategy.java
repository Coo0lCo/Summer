package scbc.lyj.beans.version4.factory.support;

import scbc.lyj.beans.version4.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author SCBC_LiYongJie
 * {@code @Date} 2022/5/6
 */
public interface InstantiationStrategy {
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor<?> constructor, Object... args);
}
