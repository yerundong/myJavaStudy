package 类和对象.内部类.局部内部类.匿名类;

public class Main {
    public static void main(String[] args) {
        // 匿名类（继承）
        TestClass obj1 = new TestClass() {
            @Override
            public void says() {
                System.out.println("匿名局部内部类1执行！");
            }

            ;
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
        new TestClass() {
            @Override
            public void says() {
                System.out.println("匿名内部类 + 匿名对象 执行！");
            }

            ;
        }.says();
    }
}
