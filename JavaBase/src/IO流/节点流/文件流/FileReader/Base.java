package IO流.节点流.文件流.FileReader;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/*
@FileReader: 字符输入文件流，属于节点流的一种；用来读取字符文件的便捷类。字符流只能处理字符数据（.txt\.html\.java\...），不能处理字节数据（图片\视频\音频\.doc\.ppt...）。
 */
public class Base {
    /**
     * @一般正确写法示例
     */
    @Test
    public void demo() {
        // 1.创建File
        File file = new File("IOTestFile\\hello-io.txt");
        FileReader fr = null;
        try {
            // 2.创建流
            fr = new FileReader(file);
            int readChar;
            // 3.读取流
            while ((readChar = fr.read()) != -1) {
                System.out.print((char) readChar);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4.关闭流
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * @构造器，创建FileReader流
     */
    @Test
    public void Constructor() throws IOException {
        // <CM> public FileReader(File file) throws FileNotFoundException
        // <返> 创建读取字符文件的流管道（文件流）；返回 FileReader 对象
        // <注> file必须存在，否则报 FileNotFoundException

        File file = new File("IOTestFile\\hello-io.txt");
        // file = new File("IOTestFile\\none.txt");// 不存在
        FileReader fr = new FileReader(file);
        fr.close();
    }

    /**
     * @读
     */
    @Test
    public void read() throws IOException {
        // <M> public int read() throws IOException
        // <返> 读取的字符数值（ascii码），如果已到达流的末尾，则返回 -1;调用一次只读取一个字符，迭代读取
        File file = new File("IOTestFile\\hello-io.txt");
        FileReader fr = new FileReader(file);
        int readChar = fr.read();
        System.out.println(readChar);
        System.out.println((char) readChar);
    }

    /**
     * @读
     */
    @Test
    public void read2() throws IOException {
        // <M>  public int read(char[] cbuf) throws IOException
        // <返> 返回读取的字符数len（len <= cbuf.length），如果已到达流的末尾，则返回 -1
        // <改> 读取的字符ascii码，将字符读入数组cbuf。每read()一次，cbuf都会被重头覆盖，如果最后一次不够数组长度，则会部分保留上一次字符
        //      （比如第一次取“hello”，第二次取”java“，cbuf的最后一次更新就是：[h,e,l,l,o] => [j,a,v,a,o]）
        // <注> 在某个输入可用、发生 I/O 错误或者已到达流的末尾前，此方法一直阻塞。
        File file = new File("IOTestFile\\hello-io.txt");
        FileReader fr = new FileReader(file);
        char[] cbuf = new char[5];
        int len;
        // for (int i = 0; i < 10; i++) {
        //     len = fr.read(cbuf);
        //     System.out.println(len);
        // }
        while ((len = fr.read(cbuf)) != -1) {
            // System.out.println(len);
            char[] chars = Arrays.copyOf(cbuf, len);
            // chars = Arrays.copyOf(cbuf, cbuf.length);// 保留了上一次字符
            // System.out.println(Arrays.toString(chars));

            String s = new String(cbuf, 0, len);
            // s = new String(cbuf);// 保留了上一次字符
            System.out.print(s);
        }
        fr.close();
    }

    /**
     * @关闭
     */
    @Test
    public void close() throws IOException {
        // <M> public void close() throws IOException
        // <改> 关闭读取文件流管道；关闭该流并释放与之关联的所有资源。在关闭该流后，再调用 read()、ready()、mark()、reset() 或 skip() 将抛出 IOException。
        // <注> 流操作完最后都需要关闭，否则浪费资源，所以经常放在finally里
        File file = new File("IOTestFile\\hello-io.txt");
        FileReader fr = new FileReader(file);
        fr.close();
    }
}
