package scbc.lyj.beans.version3;

import org.junit.Test;
import scbc.lyj.beans.version3.factory.config.BeanDefinition;
import scbc.lyj.beans.version3.factory.support.DefaultListableBeanFactory;

/**
 * @author SCBC_LiYongJie
 * {@code @Date} 2022/5/6
 */
public class BeansVersion3Tests {

    @Test
    public void test(){
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        defaultListableBeanFactory.registerBeanDefinition("userService",beanDefinition);
        UserService userService = (UserService) defaultListableBeanFactory.getBean("userService","Jie");
        userService.printfUserName();
        System.out.println(userService);
    }

}
