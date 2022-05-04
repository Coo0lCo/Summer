package scbc.lyj.beans.version1;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/20
 */
public class Test {
    public static void main(String[] args) {

        BeanFactory beanFactory = new BeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition(new TestServer());

        beanFactory.registerBeanDefinition("testBean",beanDefinition);

        Object object = beanFactory.getBean("testBean");

        TestServer testServer = (TestServer) object;

        testServer.helloWorld();
    }
}
