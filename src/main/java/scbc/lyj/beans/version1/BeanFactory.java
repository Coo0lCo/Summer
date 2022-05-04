package scbc.lyj.beans.version1;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/20
 */

public class BeanFactory {

    private final Map<String,BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    //获取bean
    public Object getBean(String name){
        return beanDefinitionMap.get(name).getBean();
    }

    //注册bean
    public void registerBeanDefinition(String name , BeanDefinition beanDefinition){
        beanDefinitionMap.put(name,beanDefinition);
    }

}
