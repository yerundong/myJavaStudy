package 接口.常量;
/**
@定义： 接口定义常量必须使用public static final三个关键字进行修饰。其实是成员变量，但效果上是常量

@格式： public static final 数据类型 常量名称 = 数据值;

@推荐命名规范： 接口中常量的名称，使用完全大写的字母，用下划线进行分隔（MY_NAME）

@备注： 一旦使用final关键字进行修饰，说明不可改变。（待学。。。）

@注意事项：
    1. 接口当中的成员变量，会默认带上public static final，写不写都一样。
    2. 接口当中的常量，必须进行赋值
    3. 常量会被实现类继承，变成类的静态变量
    4. 常量可以被隐藏
    5. 常量可以接口直接调用，也可以实现类调用，也可以实例调用（除了多重实现时重复，只能接口调用）（重点）
 */
public class Main {
    public static void main(String[] args) {
        TestClass obj = new TestClass();
        System.out.println(TestInterface.MY_NAME);
        System.out.println(TestClass.MY_NAME);
        System.out.println(obj.MY_NAME);

    }
}
