package 接口.多重实现;
/**
 @多重实现： 类只能单继承，但却同时可以实现多个接口

 @多重实现时的成员重复现象：
    1.静态方法不会被继承，只通过接口自身调用，所以不用管重复
    2.私有成员不会被出现在实现类当中，所以不用管重复
    3.常量（静态变量）重复，只能通过接口调用；或者实现类中重声明隐藏接口常量，才可以类和实例调用
    3.抽象方法重复，实现类只需重写一次
    4.默认方法重复，实现类必须重写

 @匿名实现类格式：
    new Interface(){
        ...
    };

    @注： 只能一个实现一个接口的实现类才能匿名
*/
public class Main {
    public static void main(String[] args) {
        TestClass obj = new TestClass();
        // System.out.println(TestClass.NAME);

        obj.says();
        obj.def();
        obj.def1();
        obj.def2();

        // 匿名实现类
        TestInterface1 cls = new TestInterface1(){

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
