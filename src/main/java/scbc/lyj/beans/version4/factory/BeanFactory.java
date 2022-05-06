package scbc.lyj.beans.version4.factory;

/**
 * @author SCBC_LiYongJie
 * {@code @Date} 2022/5/6
 */
public interface BeanFactory {

    Object getBean(String name);

    Object getBean(String name,Object... args);

}
