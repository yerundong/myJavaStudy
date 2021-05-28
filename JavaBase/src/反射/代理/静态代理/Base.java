package 反射.代理.静态代理;

import org.junit.jupiter.api.Test;

/*
静态代理，特征是代理类和目标对象的类都是在编译期间确定下来，不利于程序的扩展。同时，每一个代
理类只能为一个接口服务，这样一来程序开发中必然产生过多的代理。
 */

public class Base {
    /**
     * @测试静态代理模式
     */
    @Test
    public void test() {
        ClothFactory nikeFactory = new NikeFactory();

        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(nikeFactory);

        proxyClothFactory.produceCloth();
    }
}
