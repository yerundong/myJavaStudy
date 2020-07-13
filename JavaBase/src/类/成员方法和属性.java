package 类;
/*
成员变量（属性）：
    String name; // 姓名
    int age; // 年龄
成员方法（行为）：
    public void eat() {} // 吃饭
    public void sleep() {} // 睡觉
    public void study() {} // 学习

注意事项：
1. 成员变量是直接定义在类当中的，在方法外边。
2. 成员方法不要写static关键字。
 */
public class 成员方法和属性 {
    String name = "zhangsan";
    public void sayName(){
        System.out.println(this.name);
    }
}
