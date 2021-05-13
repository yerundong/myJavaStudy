package IO流.处理流.标准输入输出流;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

/*
System.in和System.out分别代表了系统标准的输入和输出设备。
默认输入设备是键盘，输出设备是显示器

System.in的类型是InputStream
System.out的类型是PrintStream，是OutputStream的子类FilterOutputStream 的子类

@通过System类的setIn，setOut方法对默认设备进行改变。
 */

public class Base {
    /**
     * @
     */
    @Test
    public void create() throws IOException {
        // 当 read 的时候，才可输入，键盘光标出现
        InputStream is = System.in;
        int read;
        while ((read = is.read()) != -1) {
            System.out.print((char) read);
        }
        is.close();
    }
}
