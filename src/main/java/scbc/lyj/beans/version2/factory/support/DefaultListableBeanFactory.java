package scbc.lyj.beans.version2.factory.support;

import scbc.lyj.beans.version2.factory.BeansException;
import scbc.lyj.beans.version2.factory.config.BeanDefinition;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author:SCBC_LiYongJie
 * @time:2022/1/21
 *
 */

public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry{

    /**
     * 1.你现在是否又一个很大的疑问，为什么要用ConcurrentHashMap啊？噢原来是为了线程安全
     * 2.那为啥我们在put bean的时候存在线程不安全的情况？
     *              首先HashMap存在线程安全的问题是什么情况下出现的，ConcurrentHashMap是怎么解决的，这些都是基础问题，都是基石！就当学习新知识把！
     *                  第一个据说是面试常考，咱小白也不知道
     *              1）HashMap的扩容操作是将原数组复制到扩容数组中，注意在多线程的环境下如果在扩容的时候另一个线程进行put操作，恰好hash值相同
     *                 出现在同一个桶下，这时候A线程执行扩容的next = e.next语句的时候，B抢占到时间片执行完第一次循环
     *                  这个时候线程A再执行，就会出现闭环，在下次get该链表上不存在的元素的时候就会死循环（这里出现死循环我没有解释很详细，要搭配图+源代码才说得清楚）
     *
     *              2）还有就是非扩容情况下的，两个线程同时put，而且都正好映射到了同一个桶，两个线程都进行头插，这里有啥问题呢，你要头插肯定要拿到头节点对吧，
     *              如果AB都拿到了头节点，此时A的时间到头了（B抢占到了时间片），B把头插执行完成了，此时A所获取的头节点过时了，当A再傻不咧爹的执行头插，把人家B给覆盖了。。。
     *              以此类推cud操作都有问题！
     *      ConcurrentHashMap在Jdk 8 中使用Synchronized和CAS来操作----详细可以直接去ConcurrentHashMap的put里面的很清楚的看到
     */
    //观看源代码可以知道spring默认的容器初始化大小是256
    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(256);

    //获取bean的定义----bean的定义力有Class对象，Class对象保存了类的信息，可以用于实例化bean对象
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
