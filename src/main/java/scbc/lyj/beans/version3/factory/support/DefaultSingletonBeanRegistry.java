package scbc.lyj.beans.version3.factory.support;


import scbc.lyj.beans.version3.factory.config.SingletonBeanRegistry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author SCBC_LiYongJie
 * {@code @Date} 2022/5/5
 */
public class DefaultSingletonBeanRegistry  implements SingletonBeanRegistry {

    private final Map<String,Object> singletonObjects = new ConcurrentHashMap<>(256);
        @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    protected void addSingleton(String beanName,Object singletonObject){
        singletonObjects.put(beanName,singletonObject);
    }

}
