package IO流.commonIO.文件流.FileReader;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Base {
    /**
     * @构造器，创建FileReader流
     */
    @Test
    public void Constructor() throws IOException {
        // <CM> public FileReader(File file) throws FileNotFoundException
        // <CM> public FileReader(String fileName) throws FileNotFoundException
        // <返> 创建读取字符文件的流管道（文件流）；返回 FileReader 对象
        // <注> file必须存在，否则报 FileNotFoundException

        File file = new File("IOTestFile\\hello-io.txt");
        // file = new File("IOTestFile\\none.txt");// 不存在
        // FileReader fr = new FileReader(file);
        FileReader fr = new FileReader("IOTestFile\\hello-io.txt");
        fr.close();
    }

    /**
     * @读
     */
    @Test
    public void read() {
        // <M> public int read() throws IOException
        // <返> 读取的字符数值，如果已到达流的末尾，则返回 -1;调用一次只读取一个字符，迭代读取
        File file = new File("IOTestFile\\hello-io.txt");
        FileReader fr = null;
        try {
            fr = new FileReader(file);
            int readChar;
            while ((readChar = fr.read()) != -1) {
                System.out.print((char) readChar);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @读
     */
    @Test
    public void read_cbuf() {
        // <M>  public int read(char[] cbuf) throws IOException
        // <返> 返回读取的字符数len（len <= cbuf.length），如果已到达流的末尾，则返回 -1
        // <改> 读取的字数，将字符数读入数组cbuf。每read()一次，cbuf都会被重头覆盖，如果最后一次不够数组长度，则会部分保留上一次字符
        //      （比如第一次取“hello”，第二次取”java“，cbuf的最后一次更新就是：[h,e,l,l,o] => [j,a,v,a,o]）
        // <注> 在某个输入可用、发生 I/O 错误或者已到达流的末尾前，此方法一直阻塞。
        File file = new File("IOTestFile\\hello-io.txt");
        FileReader fr = null;
        try {
            fr = new FileReader(file);
            // 缓冲数组：相当于拿小车运，一次运多个字符，减少运输次数，提升效率。但是太大了太占内存，所以需要一个适合的数值（暂不研究）。
            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1) {
                String s = new String(cbuf, 0, len);// 截取len长度的字符
                System.out.print(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
