package IO流.处理流.数据流;

import org.junit.jupiter.api.Test;

import java.io.*;

/*
 @数据流: DataInputStream和DataOutputStream，用于读写基本类型和字符串类型的数据（常量或变量），能够持久化储存带有类型的数据
 */
public class Base {
    /**
     * @构造器
     */
    @Test
    public void Constructor() throws IOException {
        FileOutputStream fos = new FileOutputStream("IOTestFile/writerTest.txt");
        FileInputStream fis = new FileInputStream("IOTestFile/writerTest.txt");
        DataOutputStream dos = new DataOutputStream(fos);
        DataInputStream dis = new DataInputStream(fis);
        dis.close();
        dos.close();
    }

    /**
     * @写
     */
    @Test
    public void write() throws IOException {
        // DataOutputStream提供了针对各种基本数据类型的写入
        FileOutputStream fos = new FileOutputStream("IOTestFile/writerTest.txt");
        DataOutputStream dos = new DataOutputStream(fos);
        String name = "李潇";
        int age = 18;
        boolean isStudent = true;
        dos.writeUTF(name);
        dos.write(age);
        dos.writeBoolean(isStudent);
        dos.close();
    }

    /**
     * @读
     */
    @Test
    public void read() throws IOException {
        // DataInputStream提供了针对各种基本数据类型的读入
        // <注> 一定要按写入的顺序读，否则取不到对应的数据，甚至类型不同而报错EOFException
        FileInputStream fis = new FileInputStream("IOTestFile/writerTest.txt");
        DataInputStream dis = new DataInputStream(fis);
        String name = dis.readUTF();
        int age = dis.read();
        boolean isStudent = dis.readBoolean();
        System.out.println(name);
        System.out.println(age);
        System.out.println(isStudent);
        dis.close();
    }
}
