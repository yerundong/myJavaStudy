package IO流.commonIO.文件流.FileWriter;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Base {
    /**
     * @ 构造器，创建FileWriter流
     */
    @Test
    public void Constructor() throws IOException {
        // <CM> public FileWriter(File file) throws IOException
        // <CM> public FileWriter(String fileName) throws IOException
        // <返> 创建 FileWriter 流，并返回
        // <改> 如果该文件路径不存在，则会自动创建文件，如果存在，会创建一个同名空文件覆盖它；
        // <注> 如果父目录不存在，则报错 FileNotFoundException

        // <CM> public FileWriter(File file, boolean append) throws IOException
        // <CM> public FileWriter(String fileName, boolean append) throws IOException
        // <改> 如果该文件路径不存在，则会自动创建文件，如果存在，在它基础上追加；

        File file = new File("JavaSe/src/lib/IOTestFile/writerTest.txt");
        // file = new File("JavaSe/src/lib/IOTestFile/none/writerTest.txt");// 父目录不存在
        // FileWriter fw = new FileWriter(file);
        // FileWriter fw = new FileWriter(file, true);// 追加
        FileWriter fw = new FileWriter("JavaSe/src/lib/IOTestFile/writerTest.txt", true);// 追加
        fw.close();
    }

    /**
     * @写
     */
    @Test
    public void write() throws IOException {
        // <M> public void write(int c) throws IOException
        // <M> public void write(String str) throws IOException
        // <M> public void write(char[] cbuf, int off, int len) throws IOException
        // <M> public void write(String str, int off, int len) throws IOException
        // <改> 通过FileWriter流对文件写入字符
        File file = new File("JavaSe/src/lib/IOTestFile/writerTest.txt");
        FileWriter fw = new FileWriter(file);
        // fw.write('a');
        fw.write("a\nbc");
        char[] chars = {'a', 'b', 'c', 'd'};
        // fw.write(chars, 0, chars.length);
        // fw.write("hello,io", 0, 5);
        fw.close();
    }
}
