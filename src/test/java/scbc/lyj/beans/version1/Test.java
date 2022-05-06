package scbc.lyj.beans.version1;


import scbc.lyj.beans.version2.factory.config.BeanDefinition;
import scbc.lyj.beans.version2.factory.support.DefaultListableBeanFactory;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/21
 */

public class Test {
    public static void main(String[] args) {

        //向工厂注册TestService 为bean
        BeanDefinition beanDefinition = new BeanDefinition(TestService.class);
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        defaultListableBeanFactory.registerBeanDefinition("testBean",beanDefinition);

        TestService testService1 = (TestService) defaultListableBeanFactory.getBean("testBean");

        testService1.sayHello();

        TestService testService2 = (TestService) defaultListableBeanFactory.getBean("testBean");
        testService2.sayHello();

        TestService testService3 = new TestService();

        System.out.println(testService1 == testService2);

        System.out.println(testService1 == testService3);
    }
}
