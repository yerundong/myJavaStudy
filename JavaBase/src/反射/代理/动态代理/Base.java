package 反射.代理.动态代理;

import org.junit.jupiter.api.Test;

/*
动态代理是指客户通过代理类来调用其它对象的方法，并且是在程序运行时根据需要动态创建目标类的代理对象。

@动态代理使用场合:
    1.调试
    2.远程方法调用

@动态代理相比于静态代理的优点：
    抽象角色中（接口）声明的所有方法都被转移到调用处理器一个集中的方法中处理，这样，我们可以更加灵活和统一的处理众多的方法

@要想实现动态代理，需要解决的问题：
 问题一：如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象。
 问题二：当通过代理类的对象调用方法a时，如何动态的去调用被代理类中的同名方法a。

@AOP代理:
    使用Proxy生成一个动态代理时，往往并不会凭空产生一个动态代理，这样没有太大的意义。通常都是为指定的目标对象生成动态代理
    这种动态代理在AOP中被称为AOP代理，AOP代理可代替目标对象，AOP代理包含了目标对象的全部方法。但AOP代理中的方法与目标对象的方法存在差异：
    AOP代理里的方法可以在执行目标方法之前、之后插入一些通用处理。
 */
public class Base {
    /**
     * @测试动态代理
     */
    @Test
    public void test() {
        NikeFactory nikeFactory = new NikeFactory();
        ClothFactory proxyInstance = (ClothFactory) ProxyFactory.getProxyInstance(nikeFactory);
        proxyInstance.produceCloth();
    }
}
