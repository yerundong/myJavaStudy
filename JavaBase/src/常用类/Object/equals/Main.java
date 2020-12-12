package 常用类.Object.equals;

import 示例.Student;

/**
@equals： equals是Object中的成员方法，而Object是所有类的父类，都继承了该方法，基本类型需要包装类才能使用。

@Object中的源码：
    public boolean equals(Object obj) {
        return (this == obj);
    }

@判断机制： 除【所有基本类型】和【部分引用类型】外，其他引用类型没有重写equals，他们equals的方法继承自Object，判断机制与 == 一样，判断两个类是否地址一样

@equals重写情况：
    1.基本类型的包装类（Byte，Integer...）：重写，比较【内容】是否相等
    2.字符串String：重写，比较【实体内容】是否相等
    3.Date类：重写，比较【实体内容】是否相等
    4.File类：重写，比较【实体内容】是否相等
    4.其他引用类型（对象、数组）：没有重写，比较【地址】是否相等

@特性：
     对称性：如果x.equals(y)返回是“true”，那么y.equals(x)也应该返回是“true”。
     自反性：x.equals(x)必须返回是“true”。
     传递性：如果x.equals(y)返回是“true”，而且y.equals(z)返回是“true”，那么z.equals(x)也应该返回是“true”。
     一致性：如果x.equals(y)返回是“true”，只要x和y内容一直不变，不管你重复x.equals(y)多少次，返回都是“true”。

@注意事项：
    1.只能引用类型数据调用，基本类型数据需要使用【包装类】才能调用
    2.x.equals(null)，永远返回是“false”，x.equals(和x不同类型的对象)永远返回是“false
    3.null.equals()会报空指针异常NullPointerException，所以调用之前需要判断一下非null
    4.推荐把【常量】或【确定非null的对象】用来放在前面：推荐："abc".equals(str)    不推荐：str.equals("abc")

*/
public class Main {
    public static void main(String[] args) {
        // @基本类型
        // 比较内容
        Byte byte1 = 1;
        Byte byte2 = 1;
        Short short1 = 1;
        Short short2 = 1;
        Integer int1 = 1;
        Integer int2 = 1;
        Long long1 = 1L;
        Long long2 = 1L;
        Float float1 = 1.1F;
        Float float2 = 1.1F;
        Double double1 = 1.1;
        Double double2 = 1.1;
        Character char1 = 'a';
        Character char2 = 'a';
        Boolean bool1 = false;
        boolean bool2 = false;
        System.out.println(byte1.equals(byte2));// true
        System.out.println(short1.equals(short2));// true
        System.out.println(int1.equals(int2));// true
        System.out.println(long1.equals(long2));// true
        System.out.println(float1.equals(float2));// true
        System.out.println(double1.equals(double2));// true
        System.out.println(char1.equals(char2));// true
        System.out.println(bool1.equals(bool2));// true

        System.out.println("================ part 2 ===================");

        // @字符串
        // 比较内容
        String str1 = "abc";
        String str2 = "abc";
        String str3 = new String("abc");
        String str4 = new String("abc");
        String str5 = str4;

        System.out.println(str1.equals(str2));// true
        System.out.println(str3.equals(str4));// true
        System.out.println(str2.equals(str3));// true
        System.out.println(str4.equals(str5));// true
        System.out.println("abc".equals(str1));// true

        System.out.println("================ part 3 ===================");

        // @其他引用类型
        // 没有重写equals，继承Object类的equals，是比较地址
        Student stu1 = new Student("张三");
        Student stu2 = new Student("张三");
        char[] arr1 = {'a'};
        char[] arr2 = {'a'};
        System.out.println(stu1.equals(stu2));

        // @重写类中的 equals 方法
        OverrideEquals oe1 = new OverrideEquals("张三", 15);
        OverrideEquals oe2 = new OverrideEquals("张三", 15);

        System.out.println(oe1.equals(oe2));// true


    }
}

