package 多态.转型;
/**
@向上转型： 其实就是多态。

@格式： Fu fu = new Zi();

@含义：
    把子类当做父类使用，只能使用父类有的成员，不能使用子类特有的成员。
    例如：把猫当作动物来看待，可以使用动物有的属性，但不能使用猫特有的属性。

@类似于自动类型转换： double num = 100;// int -> double，范围小->范围大，自动类型转换

@适用场景： 当不需要面对子类类型时，通过提高扩展性，或者使用父类的功能就能完成相应的操作。

@向上转型注意事项：
    1.向上转型是小范围到大范围的转变
    2.向上转型一定是安全的，许可的
    3.优点是：左边代码可以统一
    4.缺点是：不能调用子类特有的内容。解决方案是：向下转型

@****************************************************************************

@向下转型： 其实就是还原动作，类型强制转换

@格式： Zi zi = (Zi)fu;

@向下转型含义：
    向上转型之后，还原为原有类型，向下转型成功后又可以使用子类特有的内容
    例如：把猫上转型为动物来看待后，还原为猫

@适用场景： 当要使用子类特有功能时。

@类似于：
    int num = (int) 100.0;// 可以
    int num = (int) 100.5;// 精度损失

@向下转型注意事项：
    1.向下转型是大范围到小范围的转变
    2.向上转型是安全的，但向下转型是有风险的
    3.【前提条件】：必须先多态（向上转型），才能向下转型，而且只能转为原有类型，若转为其他类型，则编译过，运行报错，
      报ClassCastException（猫只能还原为猫，不能还原为狗）。所以向下转型前先用instanceof判断。

*/
public class Main {
    public static void main(String[] args) {
        // 向上转型
        Animal animal = new Cat();
        animal.eat();// 猫吃鱼
        // animal.catchMouse();// 报错（动物一定会吃，但不一定会捉老鼠）

        // 向下转型
        Cat cat = (Cat)animal;
        cat.catchMouse();// 还原成猫才捉老鼠

        // 本来是猫，扩大到动物，还原时也只能还原为猫，不能还原为狗
        // 报错：java.lang.ClassCastException（类强制转换异常）
        Dog dog = (Dog)animal;
        dog.eat();
        dog.watchHouse();

        // 没有多态，不能向下转型
        Dog dog2 = new Dog();
        // RedDog rd = (RedDog)dog;// ClassCastException
        // RedDog rd = (RedDog)dog2;// ClassCastException
    }
}
