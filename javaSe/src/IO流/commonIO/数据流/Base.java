package IO流.commonIO.数据流;

import org.junit.jupiter.api.Test;

import java.io.*;

public class Base {
    /**
     * @构造器
     */
    @Test
    public void Constructor() throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("src/lib/IOTestFile/dataStream.txt"));
        DataInputStream dis = new DataInputStream(new FileInputStream("src/lib/IOTestFile/dataStream.txt"));
        dis.close();
        dos.close();
    }

    /**
     * @写
     */
    @Test
    public void write() throws IOException {
        // DataOutputStream提供了针对各种基本数据类型的写入
        FileOutputStream fos = new FileOutputStream("src/lib/IOTestFile/dataStream.txt");
        DataOutputStream dos = new DataOutputStream(fos);
        String name = "李潇";
        int age = 18;
        boolean isStudent = true;
        dos.writeUTF(name);// writeUTF()的作用，是写入UTF-8编码的字符串数据
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
        DataInputStream dis = new DataInputStream(new FileInputStream("src/lib/IOTestFile/dataStream.txt"));
        // 数据流读取类型数据的顺序需要与写入类型数据的顺序一致
        String name = dis.readUTF();// readUTF()的作用，是从输入流中读取UTF-8编码的数据，并以String字符串的形式返回
        int age = dis.read();
        boolean isStudent = dis.readBoolean();
        System.out.println(name);
        System.out.println(age);
        System.out.println(isStudent);
        dis.close();
    }
}
