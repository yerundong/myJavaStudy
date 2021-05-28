package 反射.代理.动态代理;

/**
 * @Description 被代理类：耐克衣服工厂
 */
public class NikeFactory implements ClothFactory {

    @Override
    public void produceCloth() {
        System.out.println("Nike工程执行生产工作");
    }
}
