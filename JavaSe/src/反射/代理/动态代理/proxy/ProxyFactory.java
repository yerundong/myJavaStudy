package 反射.代理.动态代理.proxy;

import 反射.代理.动态代理.interfaces.ClothFactory;
import 反射.代理.动态代理.interfaces.PhoneFactory;
import 反射.代理.动态代理.proxy.lib.ClothHandler;
import 反射.代理.动态代理.proxy.lib.PhoneHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/*
 * @Description 代理类：给一些具体的衣服工厂代理生产工作
 */
public class ProxyFactory {
    // 调用此方法返回代理类对象。解决问题一
    public static <T> T getProxyInstance(T target) {// target：被代理类的对象
        InvocationHandler handler;
        if (target instanceof ClothFactory) {
            handler = new ClothHandler(target);
        } else if (target instanceof PhoneFactory) {
            handler = new PhoneHandler(target);
        } else {
            throw new RuntimeException("此类不在被代理的范围内");
        }
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
    }
}
