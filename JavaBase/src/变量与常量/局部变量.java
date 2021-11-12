package 变量与常量;

/**
 * @局部变量：
 * @局部变量可分为： 1.形参
 * 2.方法局部变量
 * 3.代码块局部变量
 * @存放位置： 栈
 * @作用范围： 方法内部
 * @生命周期： 方法调用至执行结束。只有在被调用的时候才分配内存空间，一旦调用结束，就释放内存空间
 * @注意事项： 1.局部变量没有默认值，都必须显示赋值，否则不能访问
 * <p>
 * 2.访问修饰符不能用于局部变量
 * 3.final可以修饰局部变量
 */
public class 局部变量 {
    public static void main(String[] args) {
        says(1);
    }

    public static void says(int num1) {
        // 形参
        System.out.println(num1);

        // 普通局部变量
        int num2;
        // System.out.println(num2);// 报错
        num2 = 2;
        System.out.println(num2);

        // 代码块局部变量
        {
            int num3 = 3;
            System.out.println(num3);
        }

        // System.out.println(num3);// 报错
    }
}
