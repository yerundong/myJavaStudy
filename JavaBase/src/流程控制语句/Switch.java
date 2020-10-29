package 流程控制语句;

/**
@switch语句使用的注意事项：
    1. 多个case后面的数值不可以重复。
    2. switch后面小括号当中只能是下列数据类型：
    3.匹配哪一个case就从哪一个位置向下执行，直到遇到了break或者整体结束为止。

@备注：
    基本数据类型：byte/short/char/int
    引用数据类型：String字符串、enum枚举

*/
public class Switch {
    public static void main(String[] args) {
        int num = 2;
        switch (num) {
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
