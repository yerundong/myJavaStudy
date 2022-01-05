package 反射.代理.静态代理;

/**
 * @Description 代理类：给一些具体的衣服工厂代理生产工作
 */
public class ProxyClothFactory implements ClothFactory {
    private ClothFactory clothFactory;

    public ProxyClothFactory(ClothFactory clothFactory) {
        this.clothFactory = clothFactory;
    }

    @Override
    public void produceCloth() {
        System.out.println("处理生产衣服之前的一些准备工作");
        clothFactory.produceCloth();// 具体的工厂执行生产衣服
        System.out.println("处理生产衣服之后的一些后续工作");
    }
}
