package scbc.lyj.beans.version1;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/20
 *      简易版本0.0.1
 */

public class BeanDefinition {

    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }

}
