package 方法;
/*
@ 方法重写（覆盖、覆写）（Override）：重写是子类对父类的允许访问的【实例方法】的实现过程进行重新编写, 返回值和形参都不能改变。即外壳不变，核心重写！
@ 注：

@ 作用：重写的好处在于子类可以根据业务需要，重定义方法的行为，也就是说子类能够根据需要实现父类的方法。

@ 重写要求：
    1. 方法的名称、参数列表（类型\个数\顺序）必须相同
    2. 返回值范围：子类重写方法必须【小于等于】父类方法（即子类的返回值是父类返回值的派生类）
    3. 访问权限：子类重写方法必须【大于等于】父类方法

@ 访问权限：public > protected > (default) > private

@ 注解：@Override 写在方法前面，可用来检测是不是有效的正确覆盖重写（可写可不写）

@ 注意事项：
    1.重写只能是子类对父类（祖先类）的重写，不能是对本类或子类方法的重写
    2.声明为 final 的方法不能被重写。
    3.子类对父类成员方法的重写和重载的前提是：子类继承该方法；所以private方法无法被重载、重写
    4.静态方法可以被继承，可以被重载，可以被重新声明，但不能被重写（重新声明其实相当于重写，只是不能注解）
    5.重写只能适用于【实例方法】.不能用于静态方法.对于静态方法,只能隐藏(隐藏只是形式上的重写，并不满足多态的特征，所以严格说不是重写)
*/
public class 重写 {

}
