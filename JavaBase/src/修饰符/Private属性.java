package 修饰符;
/*
1.private作为一种权限修饰符可以修饰类，属性和方法
2.用private修饰的类属性，方法，只能类的内部使用(读写)，对于类外部（包括它的子类和父类）来说是隐藏不可见的
3.private一般不修饰类，但是可以修饰内部类


间接访问private成员变量，通过Getter/Setter方法

规范：setXxx、getXxx的命名规则
注意：对于基本类型当中的boolean值，Getter方法一定要写成isXxx的形式，而setXxx规则不变。

对于Getter来说，不能有参数，返回值类型和成员变量对应；
对于Setter来说，不能有返回值，参数类型和成员变量对应。
*/
public class Private属性 {
    public static void main(String[] args) {
        Hero hero = new Hero();
        hero.age = 20;
        hero.frient = "钢铁侠";

        // 私有属性不能在类外访问、读写
        // hero.name = "钢铁侠";

        // 通过setter写private属性
        hero.setName("蜘蛛侠");
        // 通过getter读private属性
        String getname = hero.getName();

        hero.say();

        hero.setMale(true);
        System.out.println("是爷们们儿吗："+hero.isMale());
    }
}
class Hero {
    int age = 15;
    private String name = "闪电侠";
    public String frient = "超人";
    private boolean male;

    public void say(){
        System.out.println("age:" + age +",name:" + name + ",frient:" + frient);
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
