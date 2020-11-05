package 类和对象.内部类.局部内部类.匿名类;

/**
 @匿名类： 当一个子类或实现类只使用一次时，可以使用匿名类，或继承或实现，而快捷方便地创建实例

 @注： 匿名类只能定义是方法、构造器、代码块内部，他必须是局部的内部类

 @格式：
    父类名称 实例对象名称 = new 父类名称(){
        // 匿名内部类（继承了父类）
    };

    接口 实例对象名称 = new 接口(){
        // 匿名内部类（实现了接口）
    };
*/
public class Main {
    public static void main(String[] args) {
        // 匿名类（继承）
        TestClass obj1 = new TestClass(){
            @Override
            public void says(){
                System.out.println("匿名局部内部类1执行！");
            };
        };
        obj1.says();

        // 匿名类（实现）
        TestInterface obj2 = new TestInterface() {
            @Override
            public void look() {
                System.out.println("匿名局部内部类2执行！");
            }
        };
        obj2.look();

        // 匿名类 + 匿名对象
        new TestClass(){
            @Override
            public void says(){
                System.out.println("匿名内部类 + 匿名对象 执行！");
            };
        }.says();
    }
}
