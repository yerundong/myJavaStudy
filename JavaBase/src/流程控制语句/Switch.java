package 流程控制语句;

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

 @expression: expression 限定类型是 byte/short/char/int、String字符串、enum枚举（？），否则编译报错

 @value:
    1.value 类型要和 expression 保持一致，否则编译报错
    2.value值不能重复，，否则编译报错

 @switch语句使用的注意事项：
    3.匹配哪一个case就从哪一个位置向下执行，直到遇到了break或者整体结束为止。


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
                break;
            case 2:
                System.out.println("我好");
                // break;
            case 3:
                System.out.println("大家好");
                break;
            default:
                System.out.println("他好，我也好。");
                break;
        }

    }
}
