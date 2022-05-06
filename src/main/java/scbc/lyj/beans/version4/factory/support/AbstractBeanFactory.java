package scbc.lyj.beans.version4.factory.support;

import scbc.lyj.beans.version4.factory.BeanFactory;
import scbc.lyj.beans.version4.factory.BeansException;
import scbc.lyj.beans.version4.factory.config.BeanDefinition;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) {

        return null;
    }

    @Override
    public Object getBean(String name, Object... args) {

        return null;
    }

    protected abstract Object creatBean(String beanName, BeanDefinition beanDefinition, Object... args) throws BeansException;

}
