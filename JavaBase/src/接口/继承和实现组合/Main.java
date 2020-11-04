package 接口.继承和实现组合;
/**

@类优先原则： 继承优先于实现，父类优先于接口

@当继承与实现冲突时：
    1.抽象方法同名同参数：子类只需重写一次
    2.普通（默认）成员方法同名同参数：父类优先于接口
    3.静态方法同名同参数：父类优先于接口
    4.静态变量同名：引用不明确，子类不会继承

@注： 当出现命名冲突时，子类就必须重写或重声明
*/
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
