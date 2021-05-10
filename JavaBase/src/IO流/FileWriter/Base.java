package IO流.FileWriter;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
 @FileWriter:文件流、节点流、字符输出流；用来写入字符文件的便捷类。字符流只能处理字符数据，不能处理图片等字节数据。
 */
public class Base {
    /**
     * @一般正确写法示例
     */
    @Test
    public void demo() {
        File file = new File("IOTestFile/writerTest.txt");
        FileWriter fw = null;
        try {
            fw = new FileWriter(file, true);
            fw.write("i have a dream!");
            fw.write("\n\twe have many dreams!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * @ 构造器，创建FileWriter流
     */
    @Test
    public void Constructor() throws IOException {
        // <CM> public FileWriter(File file) throws IOException
        // <返> 创建 FileWriter 流，并返回
        // <改> 如果该文件路径不存在，则会自动创建文件，如果存在，会创建一个空文件覆盖它；
        // <注> 如果父目录不存在，则报错 FileNotFoundException

        // <CM> public FileWriter(File file, boolean append) throws IOException
        // <改> 如果该文件路径不存在，则会自动创建文件，如果存在，在它基础上追加；

        File file = new File("IOTestFile/writerTest.txt");
        // file = new File("IOTestFile/none/writerTest.txt");// 父目录不存在
        // FileWriter fw = new FileWriter(file);
        FileWriter fw = new FileWriter(file, true);// 追加
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
        // <注> 写入的字符前，会先将该文件内容全部清空
        File file = new File("IOTestFile/writerTest.txt");
        FileWriter fw = new FileWriter(file);
        // fw.write('a');
        fw.write("a\nbc");
        char[] chars = {'a', 'b', 'c', 'd'};
        // fw.write(chars, 0, chars.length);
        // fw.write("hello,io", 0, 5);
        fw.close();
    }
}
