package scbc.lyj.beans.version3.factory.support;

import scbc.lyj.beans.version3.factory.BeanFactory;
import scbc.lyj.beans.version3.factory.BeansException;
import scbc.lyj.beans.version3.factory.config.BeanDefinition;

import java.util.Objects;

/**
 * @author SCBC_LiYongJie
 * {@code @Date} 2022/5/5
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) {
        //这里呢实际上就是直接去获取单一的bean实例化对象----如果没拿到就去拿bean的定义类，再进行实例化！
        Object object = getSingleton(name);
        return Objects.isNull(object) ? creatBean(name,getBeanDefinition(name)) : object;
    }

    @Override
    public Object getBean(String name, Object... args) {
        Object object = getSingleton(name);
        return Objects.isNull(object) ? creatBean(name,getBeanDefinition(name),args) : object;
    }

    //定义其他业务方法

    //creatBean的业务拆分给AbstractAutowireCapableBeanFactory
    protected abstract Object creatBean(String beanName, BeanDefinition beanDefinition, Object... args) throws BeansException;

    //getBeanDefinition的业务拆分给DefaultListableBeanFactory
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

}
