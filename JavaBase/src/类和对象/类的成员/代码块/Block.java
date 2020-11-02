package 类和对象.类的成员.代码块;

/**

 @代码块（block）： 也叫初始化块

 @代码块分类：
     1.（实例）代码块
     2.静态代码块

 @执行顺序：
    1.静态代码块先于实例）代码块执行
    2.同一类的多个代码块凭声明顺序执行（一般不会声明多个代码块）

 一、（实例）代码块

 @格式：
     {
        ...
     }

 @用途： 给实例属性初始化

 @执行时间： 每次【创建实例】时候都会执行一次

 @创建实例时，实例结构的执行顺序：
    ①默认初始化
    ②显式初始化 /（实例）代码块执行
        @注： 显式初始化和（实例）代码块执行是同一级别的，谁在前谁先
    ③构造器初始化
    ④通过"对象.属性"或“对象.方法”去赋值

 二、静态代码块

 @格式：
     static {
        ...
     }

 @用途： 给静态变量初始化

 @执行时间： 每次【加载类】的时候都会执行一次

 @加载类时，静态结构的执行顺序：
     ①默认初始化
     ②显式初始化 / 静态代码块执行
        @注： 显式初始化和静态代码块执行是同一级别的，谁在前谁先
     ③main方法执行

 @注意：
    1.静态代码块类只能调用静态结构
    2.继承的时候先需要加载父类，所以父类的静态代码块也会先执行
 */

public class Block {

    public static void main(String[] args) {
        System.out.println("************* 入口方法执行 ***************");

        Block block1 = new Block();
        Block block2 = new Block();

        System.out.println(block1.getName());
        System.out.println(Block.getInitCount());
    }

    private String name = "default";
    private static int initCount = 0;

    // 静态代码块
    static {
        System.out.println("静态代码块执行1");
        initCount = 1;
    }

    // 实例代码块
    {
        System.out.println("实例代码块执行1");
        name = "默认名";
    }

    public Block() {
       // name = "DEF";
    }

    public Block(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static int getInitCount() {
        return initCount;
    }
}
