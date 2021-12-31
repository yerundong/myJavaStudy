package 接口.接口成员.私有方法;

import org.junit.jupiter.api.Test;

public class TestClass implements TestInterface {

    /**
     * @
     */
    @Test
    public void test() {
        // 未继承私有方法，不能调用
        // this.says1();
        // TestInterface.says2();
    }

}
