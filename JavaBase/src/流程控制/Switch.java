package 流程控制;

/**

 @语法格式：
     switch(expression){
         case value :
            ...
            break; //可选
         case value :
             ...
             break; //可选
         ...
         default : //可选
            //语句
            break; //可选
     }
 @解释：
    @switch: switch内为一个代码块，各个case之间的声明可以通用，但赋值不能通用

    @expression: expression 限定类型是 byte/short/char/int、String字符串、enum枚举（？），否则编译报错

    @case: 匹配哪一个case就从哪一个位置向下执行，直到遇到了break或者整体结束为止。

    @value:
        1.value 类型要和 expression 保持一致，否则编译报错
        2.value值不能重复，，否则编译报错

 @注意：
    1.如果case之间要定义重复的变量，可以用{}隔离

*/
public class Switch {
    public static void main(String[] args) {
        int exp = 2;// int支持
        // Integer exp = new Integer(2);// int包装类支持
        // String exp = "abc";// 字符串支持
        // String exp = new String("abc");// 字符串支持
        // long exp = 1000;// long不支持
        // float exp = 1000;// 浮点型不支持
        // Object exp = new Object();// 其他引用类型不支持

        Object obj = new Object();

        switch (exp) {
            case 1:
                System.out.println("你好");
                int a = 123;
                break;
            case 2:
                System.out.println("我好");

                // System.out.println(a);// 未初始化，报错
                a = 456;
                System.out.println(a);// 访问得到a
                // break;
            case 3:
                // 隔离
                {
                    int b = 666;
                    System.out.println(b);
                }
                System.out.println("大家好");
                break;
            default:
                {
                    int b = 777;
                    System.out.println(b);
                }
                System.out.println("他好，我也好。");
                break;
        }

    }
}
