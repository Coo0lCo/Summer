package scbc.lyj.beans.version2.factory.config;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/20
 *          bean的模版类，也是bean的包装类，定义类
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
