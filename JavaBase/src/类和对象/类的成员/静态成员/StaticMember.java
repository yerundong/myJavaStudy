package 类和对象.类的成员.静态成员;

class StaticMember {
    // 实例变量
    private String name;

    // 静态变量
    static String country = "宋";

    // 构造函数
    public StaticMember() {
    }

    public StaticMember(String name) {
        this.name = name;
    }

    // 实例方法
    public void setName(String name) {
        this.name = name;

        // 实例方法中可以调用静态方法，类名可以省略
        // StaticModifier.run();
        // run();
    }

    public void say() {
        System.out.println("name：" + this.name + ",my country is " + this.country);

        new StaticInsideClass();
        StaticMember.setCountry("中国");
        // 等同于：
        // this.setCountry("中国");
    }

    // 静态方法
    // 静态方法中不可使用this关键字，即不能访问实例变量，但可以访问静态变量和静态方法
    public static void setCountry(String country) {
        // System.out.println(name);// 无法访问实例变量

        StaticMember.country = country;

        // 类名可以省略
        // StaticModifier.run();
        // run();
    }

    public static void run() {
        System.out.println("I am static run!!!");
    }

    // 静态内部类
    static class StaticInsideClass {
        public StaticInsideClass() {
            System.out.println("我是StaticInsideClass静态内部类");
        }
    }
}
