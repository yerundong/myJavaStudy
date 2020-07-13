package 类;
/*
通常情况下，一个类并不能直接使用，需要根据类创建一个对象，才能使用。

1. 导包：
import 包名称.类名称;
例如：import cn.itcast.day06.demo01.Student;
对于和当前类属于同一个包的情况，可以省略导包语句不写。

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
        stu.say();

        System.out.println(stu.name);

        stu.friend("LiSi");

    }
}
