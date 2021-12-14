package 反射.代理.动态代理.proxied;

import 反射.代理.动态代理.interfaces.ClothFactory;

/**
 * @Description 被代理类：耐克衣服工厂
 */
public class NikeFactory implements ClothFactory {

    @Override
    public void produceCloth() {
        System.out.println("Nike工厂执行生产工作");
    }
}
