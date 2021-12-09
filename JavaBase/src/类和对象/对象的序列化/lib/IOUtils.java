package 类和对象.对象的序列化.lib;

import java.io.*;

/**
 * @Description 提供对象流读写方法来测试对象序列化
 */
public class IOUtils {
    public static void write(File file, Object obj) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static <T> T read(File file) {
        ObjectInputStream ois = null;
        T t = null;

        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            t = (T) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return t;
    }
}
