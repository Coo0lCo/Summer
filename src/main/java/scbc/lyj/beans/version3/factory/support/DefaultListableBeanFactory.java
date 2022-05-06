package scbc.lyj.beans.version3.factory.support;

import scbc.lyj.beans.version3.factory.BeansException;
import scbc.lyj.beans.version3.factory.config.BeanDefinition;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author SCBC_LiYongJie
 * {@code @Date} 2022/5/5
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {
    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(256);

    @Override
    protected BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (Objects.isNull(beanDefinition))
            throw new BeansException("该bean没有找到，可能尚未注册");
        return beanDefinition;
    }

    @Override
    public void registerBeanDefinition(String beanName,BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName,beanDefinition);
    }

}
