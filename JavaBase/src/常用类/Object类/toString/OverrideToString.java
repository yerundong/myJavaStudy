package 常用类.Object类.toString;

/**
 * @Description 重写 toString
 * @Author 叶润东
 * @Date 2020/10/26
 * @Version 1.0
 */
public class OverrideToString {
    private String name;
    private int age;

    public OverrideToString(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "OverrideToString{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}
