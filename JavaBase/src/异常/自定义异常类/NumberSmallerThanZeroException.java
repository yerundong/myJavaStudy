package 异常.自定义异常类;

/**
 * @Description 数字小于0异常
 */
public class NumberSmallerThanZeroException extends RuntimeException {
    @java.io.Serial
    static final long serialVersionUID = 2348972318239743L;

    public NumberSmallerThanZeroException() {
        super();
    }

    public NumberSmallerThanZeroException(String message) {
        super(message);
    }
}
