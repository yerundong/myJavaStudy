package 异常处理;

/**
 * @Description 自定义异常类
 */
public class DefinedException extends RuntimeException {
    @java.io.Serial
    static final long serialVersionUID = -7034896345345766939L;

    public DefinedException() {
        super("我自定义的异常");
    }

    public DefinedException(String message) {
        super(message);
    }
}
