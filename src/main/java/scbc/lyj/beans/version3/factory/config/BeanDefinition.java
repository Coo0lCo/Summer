package scbc.lyj.beans.version3.factory.config;

/**
 * @author SCBC_LiYongJie
 * {@code @Date} 2022/5/5
 */
public class BeanDefinition {
    //存放bean的类信息，需要的时候再进行实例化
    private Class<?> beanClass;

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
