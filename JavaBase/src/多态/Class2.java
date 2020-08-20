package 多态;

public class Class2 extends Class3 {
    public String name = "我是 Class2 的 name";
    public String name2 = "我是 Class2 特有的";

    public void says() {
        System.out.println("我是 Class2 的 says()");
    }

    @Override
    public void getName(){
        System.out.println("我是 Class2 的getName()：" + name);
    }
}
