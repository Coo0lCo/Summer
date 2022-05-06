package scbc.lyj.beans.version4.factory.support;

import scbc.lyj.beans.version4.factory.BeansException;
import scbc.lyj.beans.version4.factory.config.BeanDefinition;

/**
 * @author SCBC_LiYongJie
 * {@code @Date} 2022/5/6
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    private final InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object creatBean(String beanName, BeanDefinition beanDefinition, Object... args) throws BeansException {

        return null;
    }

    public abstract void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

}
