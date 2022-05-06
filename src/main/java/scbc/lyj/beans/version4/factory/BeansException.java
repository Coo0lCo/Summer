package scbc.lyj.beans.version4.factory;

/**
 * @author SCBC_LiYongJie
 * {@code @Date} 2022/5/6
 */
public class BeansException extends RuntimeException{
    public BeansException() {
    }

    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }

    public BeansException(Throwable cause) {
        super(cause);
    }

    public BeansException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
