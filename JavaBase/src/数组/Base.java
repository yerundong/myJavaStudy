package 数组;

/**
@数组： 是一种容器，可以同时存放多个数据值。

@特点：
    1. 数组是一种引用数据类型
    2. 数组只能储存同一种类型数据
    3. 数组的长度在程序运行期间不可改变

@两种常见的初始化方式：
    1. 动态初始化（指定长度）：在创建数组的时候，直接指定数组当中的数据元素个数。
    2. 静态初始化（指定内容）：在创建数组的时候，不直接指定数据个数多少，而是直接将具体的数据内容进行指定。

@动态初始化数组的格式： 数据类型[] 数组名称 = new 数据类型[数组长度];

@静态初始化格式：
    1.标准格式：
        数据类型[] 数组名称 = new 数据类型[] { 元素1, 元素2, ... };
    2.省略格式：
        数据类型[] 数组名称 = { 元素1, 元素2, ... };

@注意事项：
    1. 静态初始化没有直接指定长度，但是仍然会自动推算得到长度。
    2. 静态初始化标准格式可以拆分成为两个步骤。
    3. 动态初始化也可以拆分成为两个步骤。
    4. 静态初始化一旦使用省略格式，就不能拆分成为两个步骤了。

@使用建议：
    如果不确定数组当中的具体内容，用动态初始化；否则，已经确定了具体的内容，用静态初始化。

@数组的长度： 数组的成员个数，是int类型的整数

@访问格式： array.length

@注意事项： length是final类型，数组一旦创建，程序运行期间，length不可改变
 */
public class Base {

    public static void main(String[] args) {
        // @格式一：数组的动态初始化
        // 动态初始化会根据元素类型，给定默认值
        // 格式：数据类型[] 数组名称 = new 数据类型[数组长度];
        int[] array1 = new int[1];
        // 注：动态初始化必须写长度
        // int[] array1 = new int[];// 错误写法

        // 打印默认值
        // for (int i = 0; i < array1.length; i++) {
        //     System.out.println(array1[i]);
        // }

        // 重新赋值
        array1[0] = 0;
        // 注：若超出设定的长度，报运行时错误：ArrayIndexOutOfBoundsException
        // array1[1] = 1;



        // @格式二：数组的静态初始化
        int[] array2 = new int[]{1, 2, 3};
        // 注：静态和动态不能同时写
        // int[] array2 = new int[3]{1, 2, 3};// 错误写法

        // @格式三：静态初始化的省略写法
        String[] array3 = {"hello", "world", "java"};
        // 省略写法不能直接作为参数
        says(new int[]{1, 2, 3});
        says(new int[3]);
        // says({1, 2, 3});// 报错

        // @[]的位置
        // []可以放在类型后面（java源代码写法，推荐），也可以放在变量后面（c语言写法）
        int array4[] = new int[2];
        int array5[] = new int[]{1,2,3};
        int array6[] = {1,2,3};

        // @声明初始化分步走
        // 标准格式的初始化拆分为两个步骤：
        byte[] array7;
        array7 = new byte[]{1, 2, 3};

        float[] array8;
        array8 = new float[5];

        // 但省略模式不能分两步走
        short[] array9;
        // array9 = {1, 2, 3};// 错误写法

        // @合并声明
        int[] array10 = new int[2], array11, array12 = {1};

        // @内存地址哈希值
        // 直接打印数组名称，得到的是数组对应的：内存地址哈希值。
        System.out.println("输出1：" + array1);// [I@10f87f48

        // @长度
        System.out.println(array1.length);// 3
        // array1.length = 400;// 错误写法，长度不可改变

        // @取值设值
        array1[0] = 1;
        System.out.println(array1[0]);
    }
    static void says(int[] arr){
        // System.out.println(arr);
    }
}

