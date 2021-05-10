package IO流.FileInputStream;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Base {
    /**
     * @构造器，创建FileReader流
     */
    @Test
    public void Constructor() throws IOException {
        File file = new File("IOTestFile/writerTest.txt");
        FileInputStream fis = new FileInputStream(file);
        byte[] bytes = new byte[5];
        int len;
        while ((len = fis.read(bytes)) != -1) {
            for (int i = 0; i < len; i++) {
                System.out.print((char) bytes[i]);
            }
        }
        fis.close();
    }
}
