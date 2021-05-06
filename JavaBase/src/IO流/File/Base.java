package IO流.File;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Date;

/**
 * @File： 文件和目录路径名的抽象表示。File类的一个对象代表一个文件或文件目录（文件夹）。
 *
 * @路径分隔符和系统有关：
 * 1. windows和DOS系统默认使用“\”来表示（\在java代码中需要转义，写成\\）
 * 2. UNIX和URL使用“/”来表示
 * 注：Java程序支持跨平台运行，因此路径分隔符要慎用。
 *    为了解决这个隐患，File类提供了一个常量：separator，会根据操作系统，动态的提供分隔符。
 */

public class Base {
    /**
     * @创建File对象
     */
    @Test
    public void Constructor() {
        // <M> public File(String pathname)
        // <返> 通过将给定的路径名字符串转换为抽象路径名来创建新的File实例。 如果给定的字符串是空字符串，则结果是空的抽象路径名。

        File file1 = new File("IOTestFile\\hello-io.txt");// 相对路径
        File file2 = new File("E:\\Desktop\\myJavaStudy\\IOTestFile\\hello-io.txt");// 绝对路径
        System.out.println(file1);
        System.out.println(file2);

        // <M> public File(String parent, String child)
        // <返> 返回File对象，parent+child为一个完整的路径
        File file3 = new File("E:\\Desktop\\myJavaStudy\\IOTestFile", "hello-io.txt");
        File file4 = new File("E:\\Desktop", "myJavaStudy\\IOTestFile\\hello-io.txt");
        System.out.println(file3);
        System.out.println(file4);

        File file5 = new File("E:\\Desktop\\myJavaStudy\\IOTestFile");
        File file6 = new File(file5, "hello-io.txt");
        System.out.println(file6);

        // <M> public File(URI uri) ????
    }

    /**
     * @获取路径
     */
    @Test
    public void getPaths(){
        // <M> public String getPath()
        // <返> 返回路径名字符串。创建时传入什么就返回什么
        // <M> public String getAbsolutePath()
        // <返> 返回绝对路径名字符串。
        File file1 = new File("E:\\Desktop\\myJavaStudy\\IOTestFile\\hello-io.txt");
        File file2 = new File("IOTestFile\\hello-io.txt");
        System.out.println(file1.getPath());// E:\Desktop\myJavaStudy\IOTestFile\hello-io.txt
        System.out.println(file2.getPath());// hello-io.txt

        System.out.println(file1.getAbsolutePath());// E:\Desktop\myJavaStudy\IOTestFile\hello-io.txt
        System.out.println(file2.getAbsolutePath());// E:\Desktop\myJavaStudy\IOTestFile\hello-io.txt
    }

    /**
     * @名称
     */
    @Test
    public void getName(){
        // <M> public String getName()
        // 返回由此抽象路径名表示的文件或目录的名称。 这只是路径名称序列中的最后一个名字。 如果路径名的名称序列为空，则返回空字符串。
        File file1 = new File("E:\\Desktop\\myJavaStudy\\IOTestFile\\hello-io.txt");
        File file2 = new File("IOTestFile\\hello-io.txt");
        File file3 = new File("E:\\Desktop\\myJavaStudy\\IOTestFile");
        File file4 = new File("E:\\Desktop\\abc");

        System.out.println(file1.getName());// hello-io.txt
        System.out.println(file2.getName());// hello-io.txt
        System.out.println(file3.getName());// IOTestFile
        System.out.println(file4.getName());// abc
    }

    /**
     * @父
     */
    @Test
    public void getParents(){
        File file1 = new File("E:\\Desktop\\myJavaStudy\\IOTestFile\\hello-io.txt");
        File file2 = new File("IOTestFile\\hello-io.txt");
        File file3 = new File("IOTestFile");

        // <M> public String getParent()
        // 返回上级目录的name。是基于创建时的pathname计算出来的，所以以相对路径创建的会返回null
        System.out.println(file1.getParent());// E:\Desktop\myJavaStudy\IOTestFile
        System.out.println(file2.getParent());// IOTestFile
        System.out.println(file3.getParent());// null

        // <M> public File getParentFile()
        // 返回上级目录的File对象。是基于创建时的pathname计算出来的，所以以相对路径创建的会返回null
        System.out.println(file1.getParentFile());// E:\Desktop\myJavaStudy\IOTestFile
        System.out.println(file2.getParentFile());// IOTestFile
        System.out.println(file3.getParentFile());// null
    }

    /**
     * @长度
     */
    @Test
    public void length(){
        // <M> public long length()
        // <返> 返回由此抽象路径名表示的文件的长度。
        File file1 = new File("E:\\Desktop\\myJavaStudy\\IOTestFile\\hello-io.txt");
        File file2 = new File("IOTestFile\\hello-io.txt");
        File file3 = new File("E:\\Desktop\\myJavaStudy\\IOTestFile");
        System.out.println(file1.length());// 23
        System.out.println(file2.length());// 23
        System.out.println(file3.length());
    }

    /**
     * @上次修改的时间
     */
    @Test
    public void lastModified(){
        // <M> public long lastModified()
        // <返> 返回此抽象路径名表示的文件上次修改的时间。毫秒时间戳
        File file1 = new File("E:\\Desktop\\myJavaStudy\\IOTestFile\\hello-io.txt");
        System.out.println(file1.lastModified());// 1620295310093
        System.out.println(new Date(file1.lastModified()));
    }
}
