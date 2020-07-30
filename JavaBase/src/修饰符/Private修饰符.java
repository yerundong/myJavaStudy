package 修饰符;

import 类.Student;

/*
1.private修饰类的属性和方法：
    1.用private修饰的类属性，方法，只能类的内部使用(读写)，对于类外部（包括它的子类和父类）来说是隐藏不可见的
    2.需要访问private成员变量，可通过Getter/Setter方法
2.private修饰类，只能修饰内部类

Getter/Setter：
规范：setXxx、getXxx的命名规则；对于基本类型当中的boolean值，Getter方法要写成isXxx的形式，而setXxx规则不变
注意：
    1.对于Getter来说，不能有参数，返回值类型和成员变量对应；
    2.对于Setter来说，不能有返回值，参数类型和成员变量对应。
*/
public class Private修饰符 {
    public static void main(String[] args) {
        Hero hero = new Hero();
        hero.age = 20;
        hero.frient = "钢铁侠";

        // private属性不能在类外访问
        // hero.name = "钢铁侠";// 错误

        // 通过setter、getter访问private属性
        hero.setName("蜘蛛侠");
        String getname = hero.getName();

        hero.say();

        // private方法不能在类外调用
        // hero.axiba();// 错误
        hero.executeAxiba();

        hero.setMale(true);
        System.out.println("是爷们们儿吗："+hero.isMale());
    }

    // 修饰内部类
    private class Axiba {}// 等学了内部类再来补。。。
}
class Hero {
    int age = 15;
    // 修饰类属性
    private String name = "闪电侠";
    public String frient = "超人";
    private boolean male;

    public void say(){
        System.out.println("age:" + age +",name:" + name + ",frient:" + frient);
    }

    public void executeAxiba(){
        this.axiba();
    }

    // 修饰类方法
    private void axiba(){
        System.out.println("axiba!!!");
    }

    public void setName(String newName){
        name = newName;
    }

    public String getName(){
        return name;
    }

    public void setMale(boolean b) {
        male = b;
    }

    public boolean isMale() {
        return male;
    }

}

// private class Axiba {}// 报错，不能修饰外部类

