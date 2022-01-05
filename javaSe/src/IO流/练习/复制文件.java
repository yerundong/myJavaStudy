package IO流.练习;

import org.junit.jupiter.api.Test;

import java.io.*;

public class 复制文件 {
    /**
     * @复制文件1
     */
    @Test
    public void test1() {
        File file1 = new File("JavaSe/src/lib/IOTestFile/copy/like.txt");
        File file2 = new File("JavaSe/src/lib/IOTestFile/copy/like_copy.txt");
        this.copyFile1(file1, file2);
    }

    /**
     * @复制文件，使用缓冲流，大文件拷贝效率明显大于test1
     */
    @Test
    public void test2() {
        File file1 = new File("JavaSe/src/lib/IOTestFile/copy/like.txt");
        File file2 = new File("JavaSe/src/lib/IOTestFile/copy/like_copy.txt");
        this.copyFile2(file1, file2);
    }

    public void copyFile1(File from, File to) {
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

    public void copyFile2(File from, File to) {
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
}
