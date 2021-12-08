package IO流.各种流的使用.随机存取文件流;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Base {
    /**
     * @读
     */
    @Test
    public void read() throws IOException {
        RandomAccessFile raf = new RandomAccessFile("IOTestFile/writerTest.txt", "r");

        byte[] bytes = new byte[1024];
        int len;
        while ((len = raf.read(bytes)) != -1) {
            String s = new String(bytes);
            System.out.println(s);
        }
        raf.close();
    }

    /**
     * @写
     */
    @Test
    public void write() throws IOException {
        RandomAccessFile raf = new RandomAccessFile("IOTestFile/writerTest.txt", "rw");
        // raf.write("my life must be something wrong".getBytes());
        raf.write("xx".getBytes());
        raf.close();
    }

    /**
     * @读写
     */
    @Test
    public void seek() throws IOException {
        RandomAccessFile raf = new RandomAccessFile("IOTestFile/writerTest.txt", "rw");
        raf.seek(3);// 将指针调到索引3，从索引3开始覆盖
        raf.write("work".getBytes());
        raf.close();
    }
}
