package 层级与模块;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Math.random;
import static java.lang.System.out;

/**
 * @一、导入类\接口 单一导入： 导入类\接口格式：import 包1.包2.包3.类名/接口名;
 * 按需导入： 导入同一包下的所有类\接口，如：import 包1.包2.包3.*;（注1：不包括子包，即仅限同一级目录下）（注2：不影响执行效率，但影响编译效率）
 * @二、导入类\接口中的静态结构： 单一导入： 导入类\接口中的某个静态结构，如：import static 包1.包2.包3.类名/接口名;
 * 按需导入： 导入类\接口中的所有静态结构，如：import static 包1.包2.包3.*;（注1：不包括子包，即仅限同一级目录下）（注2：不影响执行效率，但影响编译效率）
 * @三、全名称方式： 存在命名冲突时，不用import导包，直接使用全名称方式，如：new 包1.包2.包3.类\接口();
 * @注意事项： 1.如果有 package 语句，import 语句放在 package 语句和类定义之间；如果没有 package 语句，import 语句应该在源文件中最前面。
 * 2.import 语句对源文件中定义的所有类都有效。
 * 3.java.lang包下的结构可省略导入  注：不包括lang包的子包，仅限java.lang这一级目录下类或接口
 * 4.同一包下的类或接口可省略导入
 */
public class Import {
    public static void main(String[] args) {
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
