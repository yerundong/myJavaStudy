package 接口.接口成员.常量;

public class Main {
    public static void main(String[] args) {
        TestClass obj = new TestClass();
        System.out.println(TestInterface.MY_NAME);
        System.out.println(TestClass.MY_NAME);
        System.out.println(obj.MY_NAME);

    }
}
