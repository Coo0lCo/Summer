package scbc.lyj.beans.version3.factory.support;

import scbc.lyj.beans.version3.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author SCBC_LiYongJie
 * {@code @Date} 2022/5/5
 *
 * 实例化策略接口
 * 1.JDK默认实现版本
 * 2.Cglib动态实例化bean的版本
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor<?> constructor, Object... args);

}
