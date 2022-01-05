package 反射.代理.动态代理.proxy.lib;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/*
 * @Description 执行被代理类的对象的同名方法。解决问题二
 */
public class ClothHandler<T> implements InvocationHandler {
    private T target;// 被代理类对象

    public ClothHandler(T target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        ClothUtil.productBefore();// AOP通用方法，是不变的

        Object invoke = method.invoke(target, args);// 是动态的，变化的

        ClothUtil.productAfter();// AOP通用方法，是不变的
        return invoke;
    }
}
