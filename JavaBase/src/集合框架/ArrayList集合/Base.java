package 集合框架.ArrayList集合;

import java.util.ArrayList;

/*
数组的长度不可以发生改变。
但是ArrayList集合的长度是可以随意变化的。

对于ArrayList来说，有一个尖括号<E>代表泛型（待学。。。）。
泛型：也就是装在集合当中的所有元素，全都是统一的什么类型。

注意：泛型只能是引用类型，不能是基本类型。
如果希望向集合ArrayList当中存储基本类型数据，必须使用基本类型对应的“包装类”。

注意事项：
对于ArrayList集合来说，直接打印得到的不是地址值，而是内容。
如果内容是空，得到的是空的中括号：[]
 */
public class Base {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        System.out.println(list);

        list.add("李小龙");
        list.add("成龙");
        list.add("李连杰");
        System.out.println(list);
        // list[0];// 错误写法，这是数组的取值方式
        System.out.println(list.get(0));

        // 存储基本类型数据
        // ArrayList<int> list2 = new ArrayList<>();// 错误写法
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(100);
        System.out.println(list2);

    }
}
