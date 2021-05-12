package IO流.处理流.缓冲流.BufferedReader;

import org.junit.jupiter.api.Test;

import java.io.*;

/*
@BufferedReader: 字符输入缓冲流
 */
public class Base {
    /**
     * @构造器，创建BufferedReader流
     */
    @Test
    public void Constructor() throws IOException {
        // <CM> public BufferedReader(Reader in)
        // <CM> public BufferedReader(Reader in, int sz)
        // <返> 创建 BufferedReader 对象
        File file = new File("IOTestFile\\hello-io.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        br.close();
    }

    /**
     * @读
     */
    @Test
    public void read() throws IOException {
        // <M> public int read() throws IOException
        // <返> 读取的字符数值，如果已到达流的末尾，则返回 -1;调用一次只读取一个字符，迭代读取
        File file = new File("IOTestFile\\hello-io.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        int readChar;
        while ((readChar = br.read()) != -1) {
            System.out.print((char) readChar);

        }
        br.close();
    }

    /**
     * @读
     */
    @Test
    public void read2() throws IOException {
        // <M>  public int read(char[] cbuf) throws IOException
        // <返> 返回读取的字符数len（len <= cbuf.length），如果已到达流的末尾，则返回 -1
        // <改> 读取的字数，将字符数读入数组cbuf。每read()一次，cbuf都会被重头覆盖，如果最后一次不够数组长度，则会部分保留上一次字符
        //      （比如第一次取“hello”，第二次取”java“，cbuf的最后一次更新就是：[h,e,l,l,o] => [j,a,v,a,o]）
        // <注> 在某个输入可用、发生 I/O 错误或者已到达流的末尾前，此方法一直阻塞。
        File file = new File("IOTestFile\\hello-io.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        char[] cbuf = new char[1024];
        int len;
        while ((len = br.read(cbuf)) != -1) {
            String s = new String(cbuf, 0, len);
            System.out.print(s);
        }
        br.close();
    }

    /**
     * @读行，放弃换行
     */
    @Test
    public void readLine() throws IOException {
        // <M> public String readLine() throws IOException
        // <返> 读取一个文本行。通过下列字符之一即可认为某行已终止：换行 ('\n')、回车 ('\r') 或回车后直接跟着换行。
        // 返回包含该行内容的字符串，不包含任何行终止符（换行 ('\n')、回车 ('\r') ），如果已到达流末尾，则返回 null
        BufferedReader br = new BufferedReader(new FileReader(new File("IOTestFile\\hello-io.txt")));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("IOTestFile\\hello-io_copy.txt")));
        String s;
        while ((s = br.readLine()) != null) {
            System.out.print(s);
            bw.write(s);
        }
        br.close();
        bw.close();
    }
}
