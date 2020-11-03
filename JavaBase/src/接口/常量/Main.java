package 接口.常量;
/**
@全局常量： 接口定义全局常量必须使用public static final三个关键字进行修饰。

@格式：
    public static final 数据类型 常量名称 = 数据值;

@命名规范： 大写，下划线连接（MY_CONST）

@注意事项：
    1. 接口当中的成员变量，会默认带上public static final，写不写都一样。
    2. 常量，必须进行赋值
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
