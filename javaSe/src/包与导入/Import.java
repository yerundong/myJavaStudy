package 包与导入;

import lib.Student;
import 接口.接口成员.静态方法.MyClass;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Math.random;
import static java.lang.System.out;

public class Import {
    public static void main(String[] args) {
        new Student();
        new MyClass();

        // java.lang包的结构不用导
        new ArrayList<>();
        Arrays.asList();

        // 若不用import，直接写全名也可以
        // 类重名时可用此法
        new 接口.接口成员.常量.TestClass();
        new 接口.多重实现.TestClass();

        // import static 导入 System.out
        out.println();

        // import static 导入 Math.random
        random();
    }
}
