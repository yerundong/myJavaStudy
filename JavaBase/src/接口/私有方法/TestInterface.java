package 接口.私有方法;

/**
 @注： 从Java 9开始，接口里允许定义私有方法

 @用途: 用于接口内部的代码封装

 @格式：
     private [static] 返回值类型 方法名称(参数列表) {
        方法体
     }

 @注意事项：
     1.私有方法必带有方法体
     2.私有方法只在接口内部可见，与外部无关
 */

public interface TestInterface {

    // 私有方法：
    private void says1(){
        System.out.println("i am TestInterface static says1");
    }

    private static void says3(){
        System.out.println("i am TestInterface static says3");
    }

}
