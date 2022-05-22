package scbc.lyj.beans.support;


import scbc.lyj.beans.config.BeanDefinition;

import java.lang.reflect.Constructor;

public interface InstantiationStrategy {
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor<?> constructor, Object... args);
}
