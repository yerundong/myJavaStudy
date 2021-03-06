package 接口.默认方法;

import java.util.Collection;

/**
@注： 从Java 8开始，接口里允许定义默认方法。

@用途： 接口当中的默认方法，常用来解决接口升级的问题;若是升级时添加的是抽象方法，老代码因未重写报错，而默认方法不会

@权限修饰符：
    1.public：默认，可以省略

 @格式：
    default 返回值类型 方法名称(参数列表) {
        方法体
    }

@注意事项：
    1.默认方法非抽象方法，必带有方法体
    2.默认方法会被实现类的继承作为实例方法
    3.可继承，可重写，可重载
*/
public class Main {
    public static void main(String[] args) {
        TestClass obj1 = new TestClass();
        obj1.says();
        obj1.says(1);
    }
}
