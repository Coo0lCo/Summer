package scbc.lyj.beans.support;

import scbc.lyj.beans.BeanFactory;
import scbc.lyj.beans.BeansException;
import scbc.lyj.beans.config.BeanDefinition;

import java.util.Objects;

/**
 * @author SCBC_LiYongJie
 * {@code @Date} 2022/5/22
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) {
        Object object = getSingleton(name);
        return Objects.isNull(object) ? creatBean(name,getBeanDefinition(name)) : object;
    }

    @Override
    public Object getBean(String name, Object... args) {
        Object object = getSingleton(name);
        return Objects.isNull(object) ? creatBean(name,getBeanDefinition(name),args) : object;
    }

    protected abstract Object creatBean(String beanName, BeanDefinition beanDefinition, Object... args) throws BeansException;

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;
}
