package scbc.lyj.beans.version2.factory.support;

import scbc.lyj.beans.version2.factory.BeansException;
import scbc.lyj.beans.version2.factory.config.BeanDefinition;

import java.lang.reflect.InvocationTargetException;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/20
 *
 */


public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    //AbstractAutowireCapableBeanFactory 只需要关心bean的装配就完事了BeanDefinition从哪里来我不管！业务具体拆分给了DefaultListableBeanFactory
    @Override
    protected Object creatBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean = null;
        try {
            //java 9之后弃用了bean = beanDefinition.getBeanClass().newInstance();这种方式获取实例,新的方式是通过获取public的无参构造器构造对象
            //那有参数又咋办呀！！！这里只能搞个无参的。。。。。
            bean = beanDefinition.getBeanClass().getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        addSingleton(beanName,bean);
        return bean;
    }

    public abstract void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
