package 接口.继承和实现组合;

public class Main {
    public static void main(String[] args) {
        TestClass obj = new TestClass();

        // 静态变量同名：引用不明确，子类不会继承
        // System.out.println(TestClass.MY_CONST);

        // 静态变量与成员变量同名：引用不明确，子类不会继承
        // System.out.println(obj.TIP);

        // 普通（默认）成员方法重复：父类优先于接口
        obj.look();

        // 静态方法同名：父类优先于接口
        obj.see();
        TestClass.see();

    }
}
