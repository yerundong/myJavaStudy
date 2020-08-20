package 多态;

public class Class1 extends Class2 {
    public String name = "我是 Class1 的 name ";
    public String name1 = "我是 Class1 特有的";

    public void says() {
        System.out.println("我是 Class1 的 says()");
    }

    @Override
    public void getName(){
        System.out.println("我是 Class1 的 getName()：" + name);
    }
}
