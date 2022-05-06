package scbc.lyj.beans.version4.factory.config;

/**
 * @author SCBC_LiYongJie
 * {@code @Date} 2022/5/6
 */
public class BeanDefinition {

    Class<?> beanClass;

    public BeanDefinition(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

    public Class<?> getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class<?> beanClass) {
        this.beanClass = beanClass;
    }
}
