package 类和对象.对象的序列化.lib;

import java.io.Serializable;

public class SerClass_Serializable implements Serializable {
    private static final long serialVersionUID = -8711354927592115091L;
    private String name;
    public String msg = "我是非静态变量！";
    public static String tip = "我是静态变量！";
    public transient String tra = "我是transient变量！";
    // private Person person = new Person();// Person未序列化，导致本类也无法序列化

    public SerClass_Serializable(String name) {
        this.name = name;
    }

    public static String see() {
        return "我是非静态方法！";
    }

    public static String look() {
        return "我是静态方法！";
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
