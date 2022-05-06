package scbc.lyj.beans.version4.factory.support;

import scbc.lyj.beans.version4.factory.BeansException;
import scbc.lyj.beans.version4.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author SCBC_LiYongJie
 * {@code @Date} 2022/5/6
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy{
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor<?> constructor, Object... args) {
        //首先拿到Class信息
        Class<?> clazz = beanDefinition.getBeanClass();
        try {
            if (constructor != null) {
                return clazz.getDeclaredConstructor(constructor.getParameterTypes()).newInstance(args);
            }else {
                return clazz.getDeclaredConstructor().newInstance();
            }
        }catch(InstantiationException | IllegalAccessException | InvocationTargetException |
               NoSuchMethodException e){
            throw new BeansException("Failed to instantiate [" + clazz.getName() + "]", e);
        }
    }
}