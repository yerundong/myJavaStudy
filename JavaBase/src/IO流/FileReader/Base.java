package IO流.FileReader;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Base {
    /**
     * @
     */
    @Test
    public void test() throws IOException {
        File file = new File("IOTestFile\\hello-io.txt");
        FileReader fr = new FileReader(file);
        int read = fr.read();
        System.out.println((char)read);
    }
}
