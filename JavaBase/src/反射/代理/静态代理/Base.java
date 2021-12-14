package 反射.代理.静态代理;

import org.junit.jupiter.api.Test;

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
