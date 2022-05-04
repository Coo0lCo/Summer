package scbc.lyj.beans.version2.factory.support;

import scbc.lyj.beans.version2.factory.BeanFactory;
import scbc.lyj.beans.version2.factory.BeansException;
import scbc.lyj.beans.version2.factory.config.BeanDefinition;

import java.util.Objects;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/20
 *     默认单例注册bean
 *     继承DefaultSingletonBeanRegistry
 *
 *     AbstractBeanFactory不关心bean的实例化，装配
 *     只关心bean的获取
 *     具体的实现拆分给下游抽象类和具体的实现类实现
 */

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) {
        //这里呢实际上就是直接去获取单一的bean实例化对象----如果没拿到就去拿bean的定义类，再进行实例化！
        Object object = getSingleton(name);
        return Objects.isNull(object) ? creatBean(name,getBeanDefinition(name)) : object;
    }

    //creatBean的业务拆分给AbstractAutowireCapableBeanFactory
    protected abstract Object creatBean(String beanName, BeanDefinition beanDefinition) throws BeansException;

    //getBeanDefinition的业务拆分给DefaultListableBeanFactory
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;
}
