package scbc.lyj.beans.support;

import scbc.lyj.beans.BeansException;
import scbc.lyj.beans.config.BeanDefinition;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author SCBC_LiYongJie
 * {@code @Date} 2022/5/22
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry{
    private final Map<String,BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(256);
    @Override
    protected BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (Objects.isNull(beanDefinition))
            throw new scbc.lyj.version3.factory.BeansException("该bean没有找到，可能尚未注册");
        return beanDefinition;
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName,beanDefinition);
    }
}
