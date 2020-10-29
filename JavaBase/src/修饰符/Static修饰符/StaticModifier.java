package 修饰符.Static修饰符;
/**
@ClassForStatic： 静态属性和方法
*/
class StaticModifier {
    // 普通成员变量
    private String name;

    // 静态成员变量
    static String country = "宋";

    // 构造函数
    public StaticModifier(){

    }

    public StaticModifier(String name) {
        this.name = name;
    }

    // 普通成员方法
    public void setName(String name) {
        this.name = name;

        // 实例方法中可以调用静态方法，类名可以省略
        // StaticModifier.run();
        // run();
    }
    public void say() {
        System.out.println("name：" + this.name + ",my country is "+ this.country);

        new StaticModifier.StaticInsideClass();
        StaticModifier.setCountry("中国");
        // 等同于：
        // this.setCountry("中国");
    }

    // 静态成员方法
    // 静态方法中不可使用this关键字，即不能访问实例变量，但可以访问类变量和类方法
    public static void setCountry(String country) {
        StaticModifier.country = country;

        // 类名可以省略
        // StaticModifier.run();
        // run();
    }
    public static void run(){
        System.out.println("I am static run!!!");
    }

    // 静态内部类
    static class StaticInsideClass{
        public StaticInsideClass() {
            System.out.println("我是StaticInsideClass静态内部类");
        }
    }
}
