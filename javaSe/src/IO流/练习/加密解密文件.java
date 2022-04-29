package IO流.练习;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.LinkedList;

public class 加密解密文件 {

    /**
     * @练习：加密解密文件
     */
    @Test
    public void test1() {
        File file = new File("src/lib/IOTestFile/encrypt/test.txt");
        // this.encrypt(file);
        this.decrypt(file);
    }

    public void encrypt(File src) {
        this.encryptDecrypt(src, true);
    }

    public void decrypt(File src) {
        this.encryptDecrypt(src, false);
    }

    public void encryptDecrypt(File src, Boolean encrypt) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(src));
            int b;
            LinkedList<Integer> linkedList = new LinkedList<Integer>();
            while ((b = bis.read()) != -1) {
                if (encrypt) {
                    linkedList.add((b + 2) ^ 5);
                } else {
                    linkedList.add((b ^ 5) - 2);
                }
            }
            bos = new BufferedOutputStream(new FileOutputStream(src));
            for (Integer i : linkedList) {
                bos.write(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (bos != null) {
            try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (bis != null) {
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
