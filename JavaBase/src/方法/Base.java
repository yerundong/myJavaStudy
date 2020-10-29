package 方法;

/**
@方法（Method）： 方法用于描述类的功能，是语句的集合。

@注： 在Java中，没有函数的概念，只有方法的概念。方法不能独立存在，它只能属于类或者对象。

@作用：
    1. 使程序变得更简短而清晰。
    2. 有利于程序维护。
    3. 可以提高程序开发的效率。
    4. 提高了代码的重用性。

@定义格式：
    类.修饰符 返回值类型 方法名称(参数类型 参数名称, ...) {
        方法体
        return 返回值;
    }

@注解：
    返回值类型：限制方法最终产生的数据结果的数据类型
        注：void代表没有返回值，不能return任何数据，可以不写return，要写只能写return;
    方法名称：方法的名字，规则和变量一样，小驼峰规则
    参数类型：限制进入方法的数据类型
    参数名称：进入方法的数据对应的变量名称（形参）
    方法体：方法需要做的事情，若干行代码
    返回值：方法执行后最终产生的数据结果，类型必须与前面的“返回值类型”保持一致

@命名规则： 小驼峰（myMethod）

@注意事项：
    1.方法必须定义在一个类当中
    2.方法不能定义在另一个方法当中
    3.return后面不能有其他执行语句
    4.返回值类型为void的方法，它没有返回结果，所以不能对它的执行结果赋值或访问

*/
public class Base {
    public static void main(String[] args){
        farmer();
        seller();
        cook();
        customer();
        if(false){
            return;
        }

        // 以下报错：
        // void v = customer();
        // System.out.println(customer());

    }

    // 农民
    public static void farmer(){
        System.out.println("I am farmer!");
    }

    // 商贩
    public static void seller(){
        System.out.println("I am seller!");
    }

    // 商贩
    public static void cook(){
        System.out.println("I am cook!");
    }

    // customer
    public static void customer(){
        System.out.println("I am customer!");
    }
}
