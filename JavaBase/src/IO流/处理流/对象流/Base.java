package IO流.处理流.对象流;

import org.junit.jupiter.api.Test;

import java.io.*;

/*
@ObjectInputStream和OjbectOutputSteam
    用于存储和读取基本数据类型数据或对象的处理流。它的强大之处就是可以把Java中的对象写入到数据源中，也能把对象从数据源中还原回来。

@注意：
    1.ObjectInputStream和OjbectOutputSteam操作的对象要求是可序列化的对象
    2.ObjectOutputStream和ObjectInputStream不能序列化static和transient修饰的成员变量

 序列化：用ObjectOutputStream类保存基本类型数据或对象的机制
 反序列化：用ObjectInputStream类读取基本类型数据或对象的机制
 */

public class Base {

    /**
     * @写
     */
    @Test
    public void write() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("IOTestFile/object.dat"));
        // oos.writeObject(new Person("亚索"));// 写入的对象需要实现序列化，否则报错：NotSerializableException
        // oos.writeObject(new String("亚索"));// String已经实现序列化
        oos.writeObject(new 类和对象.对象的序列化.Base("俺是可序列化类"));
        oos.close();
    }

    /**
     * @读
     */
    @Test
    public void read() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("IOTestFile/object.dat"));
        类和对象.对象的序列化.Base p = (类和对象.对象的序列化.Base) ois.readObject();
        ois.close();
        System.out.println(p);
        System.out.println(p.getName());
    }
}
