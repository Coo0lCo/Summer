package scbc.lyj.beans.version3.factory.support;

import scbc.lyj.beans.version3.factory.BeansException;
import scbc.lyj.beans.version3.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author SCBC_LiYongJie
 * {@code @Date} 2022/5/5
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private final InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object creatBean(String beanName, BeanDefinition beanDefinition,Object[] args) throws BeansException {
        Object bean;
        try {
            bean = createBeanInstance(beanName, beanDefinition, args);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        addSingleton(beanName,bean);
        return bean;
    }

    protected Object createBeanInstance(String beanName, BeanDefinition beanDefinition,Object[] args){
        Class<?> clazz = beanDefinition.getBeanClass();
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();

        //显然我们发现这咋过滤方式相当简易，还未对类型做比对，这样传入参数如果类型对不上号就完蛋！后期版本填坑！
        Constructor<?> constructorToUse = Arrays.stream(constructors)
                //只做了数量比对来找到有参构造器，显然不太行
                .filter(constructor -> (args != null && constructor.getParameterTypes().length == args.length))
                .collect(Collectors.toList()).get(0);

        return instantiationStrategy.instantiate(beanDefinition,beanName,constructorToUse,args);
    }

    public abstract void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
