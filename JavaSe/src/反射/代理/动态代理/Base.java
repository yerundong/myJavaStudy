package 反射.代理.动态代理;

import org.junit.jupiter.api.Test;
import 反射.代理.动态代理.interfaces.ClothFactory;
import 反射.代理.动态代理.interfaces.PhoneFactory;
import 反射.代理.动态代理.proxied.MiFactory;
import 反射.代理.动态代理.proxied.NikeFactory;
import 反射.代理.动态代理.proxy.ProxyFactory;

/*

@AOP代理:
    使用Proxy生成一个动态代理时，往往并不会凭空产生一个动态代理，这样没有太大的意义。通常都是为指定的目标对象生成动态代理
    这种动态代理在AOP中被称为AOP代理，AOP代理可代替目标对象，AOP代理包含了目标对象的全部方法。但AOP代理中的方法与目标对象的方法存在差异：
    AOP代理里的方法可以在执行目标方法之前、之后插入一些通用处理。
 */
public class Base {
    @Test
    public void test1() {
        NikeFactory nikeFactory = new NikeFactory();
        ClothFactory proxyInstance = ProxyFactory.getProxyInstance(nikeFactory);
        proxyInstance.produceCloth();
    }

    @Test
    public void test2() {
        MiFactory miFactory = new MiFactory();
        PhoneFactory proxyInstance = ProxyFactory.getProxyInstance(miFactory);
        proxyInstance.producePhone();
    }
}
