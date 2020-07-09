package 方法;

/*
定义方法的格式：
修饰符 返回值类型 方法名 （参数列表）｛
	代码...（方法体）
	return ;
｝
注意事项：
1.方法应该定义在一个类当中
2.但不能在方法里定义另一个方法
3.return后面不能有其他执行语句

*/
public class 方法的定义 {
    public static void main(String[] args){
        farmer();
        seller();
        cook();
        customer();
        if(true){
            return;
        }
        customer();
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
