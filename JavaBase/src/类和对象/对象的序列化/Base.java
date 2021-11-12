package 类和对象.对象的序列化;

import java.io.Serializable;

public class Base implements Serializable {
    private static final long serialVersionUID = 236544445544346L;
    private String name;
    // private Person person = new Person();// Person也必须可序列化

    public Base(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "serializedClass{" +
                "name='" + name + '\'' +
                '}';
    }
}
