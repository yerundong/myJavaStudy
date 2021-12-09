package 文件.File;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;


public class Base {
    /**
     * @创建File对象
     */
    @Test
    public void Constructor() {
        // <M> public File(String pathname)
        // <返> 通过将给定的路径名字符串转换为抽象路径名来创建新的File实例。 如果给定的字符串是空字符串，则结果是空的抽象路径名。

        File file1 = new File("IOTestFile/hello-io.txt");// 相对路径
        File file2 = new File("E:/Desktop/myJavaStudy/IOTestFile/hello-io.txt");// 绝对路径
        File file2_ = new File("IOTestFile/none");// 不存在
        System.out.println(file1);
        System.out.println(file2);
        System.out.println(file2_);

        // <M> public File(String parent, String child)
        // <返> 返回File对象，parent+child成为一个完整的路径
        File file3 = new File("IOTestFile", "hello-io.txt");
        File file4 = new File("IOTestFile/up", "go/fight.txt");
        System.out.println(file3);
        System.out.println(file4);

        File file5 = new File("IOTestFile");
        File file6 = new File(file5, "hello-io.txt");
        System.out.println(file6);

        // <M> public File(URI uri) ????
    }

    /**
     * @创建文件
     */
    @Test
    public void createNewFile() throws IOException {
        // <M> public boolean createNewFile()
        // <返，改> 根据File对象创建硬盘中的实体文件，若文件存在则不创建，返回false
        File file1 = new File("IOTestFile/newFile.txt");
        // file1 = new File("IOTestFile/none/newFile.txt");// 父目录不存在，会报错，需要判断父目录是否存在
        File parentFile = file1.getParentFile();
        if (file1.exists()) {
            file1.delete();
            System.out.println("文件删除成功！");
        } else if (!parentFile.exists()) {
            System.out.println("父目录：" + parentFile + "不存在，无法创建！");
        } else {
            file1.createNewFile();
            System.out.println("文件创建成功！");
        }
    }

    /**
     * @创建文件目录
     */
    @Test
    public void mkdir() {
        // <M> public boolean mkdir()
        // <返，改> 根据File对象创建硬盘中的实体文件目录，若【文件目录存在或者父目录不存在】，则不创建，返回false
        File file1 = new File("IOTestFile/newDir");
        // file1 = new File("IOTestFile/none/newDir");// 父目录不存在，不创建
        File parentFile = file1.getParentFile();
        if (file1.exists()) {
            file1.delete();
            System.out.println("文件夹删除成功！");
        } else if (!parentFile.exists()) {
            System.out.println("父目录：" + parentFile + "不存在，无法创建！");
        } else {
            file1.mkdir();
            System.out.println("文件夹创建成功！");
        }
    }

    /**
     * @递归创建文件目录
     */
    @Test
    public void mkdirs() {
        // <M> public boolean mkdir()
        // <返，改> 根据File对象创建硬盘中的实体文件目录，若文件目录存在，则不创建，返回false，若父目录不存在，连所需父目录一并创建
        File file1 = new File("IOTestFile/newDirs");
        file1 = new File("IOTestFile/none/newDir");// 若父目录不存在，连所需父目录一并创建
        if (file1.exists()) {
            file1.delete();
            new File("IOTestFile/none").delete();
            System.out.println("文件夹删除成功！");
        } else {
            file1.mkdirs();
            System.out.println("文件夹创建成功！");
        }
    }

    /**
     * @获取路径
     */
    @Test
    public void delete() throws IOException {
        // <M> public boolean delete()
        // <返，改> 根据File对象删除硬盘中的文件或目录。如果目录不为空或路径不存在，不删除，返回false。
        File file1 = new File("IOTestFile/newFile.txt");
        File file2 = new File("IOTestFile/newDir");
        File file3 = new File("IOTestFile/none");// 不存在
        File file4 = new File("IOTestFile/up");// 目录不为空
        file1.createNewFile();
        file2.createNewFile();
        System.out.println(file1.delete());
        System.out.println(file2.delete());
        System.out.println(file3.delete());// false
        System.out.println(file4.delete());// false
    }

    /**
     * @获取路径
     */
    @Test
    public void getPath_getAbsolutePath() {
        File file1 = new File("E:/Desktop/myJavaStudy/IOTestFile/hello-io.txt");
        File file2 = new File("IOTestFile/hello-io.txt");

        // <M> public String getPath()
        // <返> 返回路径名字符串。创建时传入什么就返回什么。toString返回getPath。
        System.out.println(file1.getPath());// E:\Desktop\myJavaStudy\IOTestFile\hello-io.txt
        System.out.println(file2.getPath());// hello-io.txt

        // <M> public String getAbsolutePath()
        // <返> 返回绝对路径名字符串。
        System.out.println(file1.getAbsolutePath());// E:\Desktop\myJavaStudy\IOTestFile\hello-io.txt
        System.out.println(file2.getAbsolutePath());// E:\Desktop\myJavaStudy\IOTestFile\hello-io.txt
    }

    /**
     * @路径是否绝对
     */
    @Test
    public void isAbsolute() {
        // <M> public boolean isAbsolute()
        // <返> 判断是目录或文件路径是否是绝对的，不存在返回false
        File file1 = new File("E:/Desktop/myJavaStudy/IOTestFile/hello-io.txt");
        File file2 = new File("IOTestFile/hello-io.txt");
        File file3 = new File("IOTestFile/none");

        System.out.println(file1.isAbsolute());// true
        System.out.println(file2.isAbsolute());// false
        System.out.println(file3.isAbsolute());// false
    }

    /**
     * @名称
     */
    @Test
    public void getName() {
        // <M> public String getName()
        // 返回由此抽象路径名表示的文件或目录的名称。 这只是路径名称序列中的最后一个名字。 如果路径名的名称序列为空，则返回空字符串。
        File file1 = new File("E:/Desktop/myJavaStudy/IOTestFile/hello-io.txt");
        File file2 = new File("IOTestFile/hello-io.txt");
        File file3 = new File("IOTestFile");
        File file4 = new File("IOTestFile/none");// 不存在

        System.out.println(file1.getName());// hello-io.txt
        System.out.println(file2.getName());// hello-io.txt
        System.out.println(file3.getName());// IOTestFile
        System.out.println(file4.getName());// none
    }

    /**
     * @父
     */
    @Test
    public void getParent_getParentFile() {
        File file1 = new File("IOTestFile/up/go");
        File file2 = new File("IOTestFile/hello-io.txt");
        File file3 = new File("IOTestFile");

        // <M> public String getParent()
        // 返回上级目录的name。是基于创建时的pathname计算出来的，所以以相对路径创建的会返回null
        System.out.println(file1.getParent());// IOTestFile/up
        System.out.println(file2.getParent());// IOTestFile
        System.out.println(file3.getParent());// null

        // <M> public File getParentFile()
        // 返回上级目录的File对象。是基于创建时的pathname计算出来的，所以以相对路径创建的会返回null
        System.out.println(file1.getParentFile());// IOTestFile/up
        System.out.println(file2.getParentFile());// IOTestFile
        System.out.println(file3.getParentFile());// null
    }

    /**
     * @长度
     */
    @Test
    public void length() {
        // <M> public long length()
        // <返> 返回由此抽象路径名表示的文件的长度（以字节为单位）。如果此路径名表示目录，则返回值未指定。
        File file1 = new File("IOTestFile/hello-io.txt");
        File file2 = new File("IOTestFile/hello-io.txt");
        File file3 = new File("IOTestFile");
        System.out.println(file1.length());// 23
        System.out.println(file2.length());// 23
        System.out.println(file3.length());
    }

    /**
     * @上次修改的时间
     */
    @Test
    public void lastModified() {
        // <M> public long lastModified()
        // <返> 返回此抽象路径名表示的文件上次修改的时间。毫秒时间戳
        File file1 = new File("IOTestFile/hello-io.txt");
        System.out.println(file1.lastModified());// 1620295310093
        System.out.println(new Date(file1.lastModified()));
    }

    /**
     * @列表
     */
    @Test
    public void list_listFiles() {
        File file1 = new File("IOTestFile/hello-io.txt");
        File file2 = new File("IOTestFile");
        File file3 = new File("IOTestFile/none");// 不存在

        // <M> public String[] list()
        // <返> 返回一个字符串数组，包含该目录下的所有一级文件和目录的name。
        System.out.println(file1.list());// null
        System.out.println(Arrays.toString(file2.list()));// [hello-io.txt, up]
        System.out.println(file3.list());// null

        // <M> public File[] listFiles()
        // <返> 返回一个File数组，包含该目录下的所有一级文件和目录的File对象。
        System.out.println(Arrays.toString(file1.listFiles()));// null
        System.out.println(Arrays.toString(file2.listFiles()));
        System.out.println(file3.listFiles());// null
    }

    /**
     * @重设（名称、路径）
     */
    @Test
    public void renameTo() {
        // <M> public boolean renameTo(File dest)
        // <返、改> 重设文件的名称和路径
        // <注> 要想重设成功（返回true），必须保证file1存在，file2不存在
        File file1 = new File("IOTestFile/up/go/fight.txt");
        File file2 = new File("IOTestFile/up/high.png");
        System.out.println(file1.renameTo(file2));
        // file2.renameTo(file1);// 复原
    }

    /**
     * @判断文件类型
     */
    @Test
    public void isFile_isDirectory() {
        // <M> public boolean isFile()
        // <M> public boolean isDirectory()
        // <返> 判断是目录还是文件类型，不存在返回false
        File file1 = new File("IOTestFile/up/go/fight.txt");
        File file2 = new File("IOTestFile/up");
        File file3 = new File("IOTestFile/none");// 不存在
        System.out.println(file1.isFile());
        System.out.println(file1.isDirectory());
        System.out.println(file2.isDirectory());
        System.out.println(file3.isDirectory());// false
    }

    /**
     * @是否文件存在
     */
    @Test
    public void exists() {
        // <M> public boolean exists()
        // <返> 判断是目录或文件是否存在，不存在返回false
        File file1 = new File("IOTestFile/up/go/fight.txt");
        File file2 = new File("IOTestFile/none");// 不存在
        System.out.println(file1.exists());
        System.out.println(file2.exists());
    }

    /**
     * @是否可读/可写
     */
    @Test
    public void canRead_canWrite() {
        // <M> public boolean canRead/canWrite()
        // <返> 判断是目录或文件是否可读/可写，不存在返回false
        File file1 = new File("IOTestFile/hello-io.txt");
        File file2 = new File("IOTestFile/up");
        File file3 = new File("IOTestFile/none");// 不存在
        File file4 = new File("IOTestFile/noReadWrite.txt");// 不可读可写
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file2.canRead());
        System.out.println(file2.canWrite());
        System.out.println(file3.canRead());// false
        System.out.println(file3.canWrite());// false
        System.out.println(file4.canRead());// false
        System.out.println(file4.canWrite());// false
    }

    /**
     * @是否可执行
     */
    @Test
    public void canExecute() {
        // <M> public boolean canExecute()
        // <返> 判断是目录或文件是否可执行，不存在返回false
        File file1 = new File("IOTestFile/up/go/fight.txt");
        File file2 = new File("IOTestFile/up");
        File file3 = new File("IOTestFile/none");// 不存在
        File file4 = new File("IOTestFile/noReadWrite.txt");// 不可读可写
        System.out.println(file1.canExecute());
        System.out.println(file2.canExecute());
        System.out.println(file3.canExecute());// false
        System.out.println(file4.canExecute());// false
    }

    /**
     * @是否隐藏
     */
    @Test
    public void isHidden() {
        // <M> public boolean isHidden()
        // <返> 判断是目录或文件是否隐藏，不存在返回false
        File file1 = new File("IOTestFile/hello-io.txt");
        File file2 = new File("IOTestFile/hidden.txt");// 隐藏
        File file3 = new File("IOTestFile/none");// 不存在
        System.out.println(file1.isHidden());// false
        System.out.println(file2.isHidden());// true
        System.out.println(file3.isHidden());// false
    }
}
