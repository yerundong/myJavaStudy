package 类;
/*
通常情况下，一个类并不能直接使用，需要根据类创建一个对象，才能使用。

1. 导包：
import 包名称.类名称;
例如：import cn.itcast.day06.demo01.Student;
注意：
    1.当前类所属于同一包的类，省略导包
    2.java.lang下的包的类，省略导包
    3.其他情况都需要import导包

2. 创建（实例化），格式：
类名称 对象名 = new 类名称();
Student stu = new Student();

3. 使用，分为两种情况：
使用成员变量：对象名.成员变量名
使用成员方法：对象名.成员方法名(参数)

注意事项：
如果成员变量没有进行赋值，那么将会有一个默认值，规则和数组一样。
 */

import 类.Student;

public class 类的导入和调用 {
    public static void main(String[] args) {
        Student stu = new Student();
        System.out.println(stu);

        stu.say();

        System.out.println(stu.name);

        stu.friend("LiSi");

        stu.age = 20;

        System.out.println(stu.age);

        beParam(stu);

        Student stu2 = beReturn();
        System.out.println(stu2);;
    }

    // 当一个对象类型作为一个参数或返回值时，它其实是传对象的地址值；
    public static void beParam(Student param){
        System.out.println(param);
    }

    public static Student beReturn(){
        Student stu = new Student();
        return stu;
    }
}
