package scbc.lyj.beans.version3;

/**
 * @author SCBC_LiYongJie
 * {@code @Date} 2022/5/6
 */
public class UserService {
    private final String name;

    public UserService(String name) {
        this.name = name;
    }

    public void printfUserName(){
        System.out.println("打印用户信息Name="+name);
    }

    @Override
    public String toString() {
        return "UserService{" +
                "name='" + name + '\'' +
                '}';
    }
}
