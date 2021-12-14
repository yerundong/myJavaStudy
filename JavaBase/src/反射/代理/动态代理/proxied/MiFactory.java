package 反射.代理.动态代理.proxied;

import 反射.代理.动态代理.interfaces.PhoneFactory;

public class MiFactory implements PhoneFactory {
    @Override
    public void producePhone() {
        System.out.println("小米工厂执行生产工作");
    }
}
