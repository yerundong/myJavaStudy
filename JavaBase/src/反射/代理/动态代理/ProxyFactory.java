package 反射.代理.动态代理;

import java.lang.reflect.Proxy;

/*
 * @Description 代理类：给一些具体的衣服工厂代理生产工作
 *
 */
public class ProxyFactory {
    // 调用此方法返回代理类对象。解决问题一
    public static Object getProxyInstance(Object target) {// obj：被代理类的对象
        ClothInvocationHandler handler = new ClothInvocationHandler();
        handler.bind(target);
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
    }
}
