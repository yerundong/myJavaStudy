package 接口.多重继承;

public class ImplClass implements SubInterface {
    // 抽象方法重写
    @Override
    public void abs() {
        System.out.println("TestClass abs");
    }

    @Override
    public void abs1() {
        System.out.println("TestClass abs1");
    }

    @Override
    public void abs2() {
        System.out.println("TestClass abs2");
    }
}
