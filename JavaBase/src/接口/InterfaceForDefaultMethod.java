package 接口;
/*
@ InterfaceForDefaultMethod：接口中的默认方法

从Java 8开始，接口里允许定义默认方法。
默认方法非抽象方法，必带有方法体

格式：
public default 返回值类型 方法名称(参数列表) {
    方法体
}

备注：接口当中的默认方法，常用来解决接口升级的问题。
    若是升级时添加抽象方法，则实现类未重写而报错，而默认方法不用。
*/
public interface InterfaceForDefaultMethod {
    // 抽象方法：
    void says1();

    // 默认方法：
    public default void says2(){
        System.out.println("i am InterfaceForDefaultMethod default says1");
    };
}
