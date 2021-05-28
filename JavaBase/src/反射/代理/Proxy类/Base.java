package 反射.代理.Proxy类;

import org.junit.jupiter.api.Test;
import 反射.lib.People;
import 反射.lib.Son;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
@Proxy类：动态代理类（以下简称为代理类），提供用于创建动态代理类和实例的静态方法，它还是由这些方法创建的所有动态代理类的超类。
Proxy是一个实现在创建类时在运行时指定的接口列表的类。

@InvocationHandler接口：是代理实例的调用处理程序 实现的接口。
每个代理实例都具有一个关联的调用处理程序。对代理实例调用方法时，将对方法调用进行编码并将其指派到它的调用处理程序的 invoke 方法。

 */
public class Base {
    /**
     * @获取代理类实例
     */
    @Test
    public void newProxyInstance() {
        // <SM> public static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)
        // <返> 返回一个指定接口（interface）的代理类实例，该接口可以将方法调用指派到指定的调用处理程序（InvocationHandler）。
        // <参> loader:被代理类的类加载器，interfaces:被代理类的实现接口，h:指派方法调用的调用处理程序
        Son son = new Son("a");

        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return method.invoke(son, args);
            }
        };

        People p = (People) Proxy.newProxyInstance(son.getClass().getClassLoader(), son.getClass().getInterfaces(), handler);

        p.eat();
    }
}
