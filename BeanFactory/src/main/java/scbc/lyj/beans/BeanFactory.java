package scbc.lyj.beans;

public interface BeanFactory {
    Object getBean(String name);
    Object getBean(String name,Object... args);
}
