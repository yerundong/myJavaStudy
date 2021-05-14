package IO流.处理流.对象流;

import org.junit.jupiter.api.Test;
import 示例.Person;

import java.io.*;

public class Base {

    /**
     * @写
     */
    @Test
    public void write() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("IOTestFile/object.dat"));
        oos.writeObject(new Person("亚索"));// 写入的对象需要实现序列化，否则报错：NotSerializableException
        oos.close();
    }

    /**
     * @读
     */
    @Test
    public void read() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("IOTestFile/object.dat"));
        Person p = (Person) ois.readObject();
        ois.close();
        System.out.println(p);
    }
}
