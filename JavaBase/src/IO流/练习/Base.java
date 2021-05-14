package IO流.练习;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.LinkedList;

public class Base {
    /**
     * @练习FileInputStream、FileOutputStream： 复制文件
     */
    @Test
    public void exe4() {
        File file1 = new File("IOTestFile/test.zip");
        File file2 = new File("IOTestFile/test_copy.zip");
        this.copyImg(file1, file2);
    }

    public void copyImg(File from, File to) {
        long start = System.currentTimeMillis();
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(from);
            fos = new FileOutputStream(to);
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
            long end = System.currentTimeMillis();
            long diff = end - start;
            System.out.println("复制成功！花费时间：" + diff + "ms");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * @练习BufferedInputStream、BufferedOutputStream： 复制文件，与exe4比较效率，大文件拷贝效率exe5明显大于exe4
     */
    @Test
    public void exe5() {
        File file1 = new File("IOTestFile/test.zip");
        File file2 = new File("IOTestFile/test_copy.zip");
        this.copyImg2(file1, file2);
    }

    public void copyImg2(File from, File to) {
        long start = System.currentTimeMillis();
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            fis = new FileInputStream(from);
            fos = new FileOutputStream(to);
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
            long end = System.currentTimeMillis();
            long diff = end - start;
            System.out.println("复制成功！花费时间：" + diff + "ms");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * @练习：加密解密文件
     */
    @Test
    public void test() {
        System.out.println((199 * 2) ^ 5);// 395
        System.out.println((395 ^ 5) / 2);//
    }

    @Test
    public void exe6() {
        File file = new File("IOTestFile/encrypt/model.zip");
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
