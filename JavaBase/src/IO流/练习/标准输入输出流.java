package IO流.练习;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class 标准输入输出流 {
    /**
     * @将键盘输入的内容转成大写
     */
    @Test
    public void exe() throws IOException {
        InputStream is = System.in;
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String s;
        System.out.print("请输入：");
        while ((s = br.readLine()) != null) {
            if ("exit".equalsIgnoreCase(s)) {
                System.out.println("已退出！");
                break;
            }
            System.out.println(s.toUpperCase());
        }
        is.close();
    }
}
