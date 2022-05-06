package scbc.lyj.beans.version3.factory.support;

import scbc.lyj.beans.version3.factory.BeansException;
import scbc.lyj.beans.version3.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author SCBC_LiYongJie
 * {@code @Date} 2022/5/5
 * 默认的Jdk实现的策略
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy{

    /**
     * @param beanDefinition bean包装对象
     * @param beanName  bean的名字
     * @param constructor   反射包下的构造器类，为构造实例提供构造器的相关参数以及类型等等
     * @param args  有参构造的参数数组
     * @return 返回一个bean
     */
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
