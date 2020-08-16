package 接口;
/*
@ ClassForAbstractMethod：实现InterfaceForAbstractMethod接口的实现类


*/
public class ClassForAbstractMethod implements InterfaceForAbstractMethod {
    @Override
    public void says1() {
        System.out.println("i am ClassForAbstractMethod says1");
    }

    @Override
    public void says2() {
        System.out.println("i am ClassForAbstractMethod says2");
    }
}
