package IO流.commonIO.对象流;

import org.junit.jupiter.api.Test;
import 类和对象.对象的序列化.lib.SerClass_Serializable;

import java.io.*;


public class Base {

    /**
     * @写
     */
    @Test
    public void write() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("JavaSe/src/lib/IOTestFile/object.dat"));

        // oos.writeObject(new Person("亚索"));// 写入的对象需要实现序列化，否则报错：NotSerializableException
        // oos.writeObject(new String("亚索"));// String已经实现序列化

        oos.writeObject(new SerClass_Serializable("俺是可序列化类"));
        oos.close();
    }

    /**
     * @读
     */
    @Test
    public void read() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("JavaSe/src/lib/IOTestFile/object.dat"));
        SerClass_Serializable p = (SerClass_Serializable) ois.readObject();
        ois.close();
        System.out.println(p);
        System.out.println(p.msg);
        System.out.println(p.getName());
        System.out.println(p.see());
    }
}
