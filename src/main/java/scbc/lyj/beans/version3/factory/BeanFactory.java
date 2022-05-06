package scbc.lyj.beans.version3.factory;

/**
 * @author SCBC_LiYongJie
 * {@code @Date} 2022/5/5
 */
public interface BeanFactory {

    Object getBean(String name);

    Object getBean(String name,Object... args);

}
