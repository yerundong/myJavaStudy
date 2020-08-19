package 接口.继承和实现组合;
/*

@ 优先级：继承优先于实现，父类优先于接口

@ 注意事项：
    1.抽象方法重复：子类只需重写一次
    2.普通（默认）成员方法重复：父类优先于接口
    3.静态方法重复：父类优先于接口
    4.静态变量重复：引用不明确，子类不会继承；若子类调用，必须子类重新声明，隐藏父类和继承的静态变量
*/
public class Main {
    public static void main(String[] args) {
        TestSubClass obj = new TestSubClass();

        // 抽象方法重复：子类只需重写一次

        // 普通成员方法重复：父类优先于接口
        obj.look();

        // 静态方法重复：父类优先于接口
        obj.see();
        TestSubClass.see();

        // 静态变量重复：引用不明确，子类不会继承；若子类调用，必须子类重新声明，隐藏父类和继承的静态变量
        // System.out.println(TestSubClass.MY_CONST);
    }
}
