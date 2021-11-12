package 接口.多重实现;

public class Main {
    public static void main(String[] args) {
        TestClass obj = new TestClass();
        // System.out.println(TestClass.NAME);

        obj.says();
        obj.def();
        obj.def1();
        obj.def2();

        // 匿名实现类
        TestInterface1 cls = new TestInterface1() {

            @Override
            public void says() {

            }

            @Override
            public void def() {

            }

            @Override
            public void def1() {

            }
        };


    }
}
