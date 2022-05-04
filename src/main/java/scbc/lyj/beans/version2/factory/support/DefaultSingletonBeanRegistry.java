package scbc.lyj.beans.version2.factory.support;

import scbc.lyj.beans.version2.factory.config.SingletonBeanRegistry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/21
 *      默认的单例注册bean
 *      DefaultSingletonBeanRegistry的主要职责是单例注册bean-----注册bean业务的主要实现类，核心类
 */


public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    //
    private final Map<String,Object> singletonObjects = new ConcurrentHashMap<>(256);

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    protected void addSingleton(String beanName,Object singletonObject){
        singletonObjects.put(beanName,singletonObject);
    }

}
