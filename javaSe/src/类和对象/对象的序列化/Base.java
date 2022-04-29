package 类和对象.对象的序列化;

import org.junit.jupiter.api.Test;
import 类和对象.对象的序列化.lib.IOUtils;
import 类和对象.对象的序列化.lib.SerClass_Serializable;

import java.io.File;

public class Base {
    private File file = new File("src/lib/IOTestFile/serialize.dat");

    @Test
    public void test_Serializable() {
        SerClass_Serializable ser = new SerClass_Serializable("我是可序列化类");

        IOUtils.write(file, ser);// 将序列化对象储存到本地

        SerClass_Serializable ser_ = IOUtils.read(file);// 将本地序列化对象读取到内存

        // 非静态成员
        System.out.println(ser_.msg);
        System.out.println(ser_.see());

        // 静态成员
        SerClass_Serializable.tip = "nononononono";
        System.out.println(ser_.tip);// nononononono，并没有取到反序列化对象的值，而是取类的值
        System.out.println(ser_.look());

        // transient修饰的变量
        System.out.println(ser_.tra);
    }
}
