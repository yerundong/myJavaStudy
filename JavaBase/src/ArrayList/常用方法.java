package ArrayList;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class 常用方法 {
    public static void main(String[] args) {
        // <M> add(E e)
        // <M> add(int index, E e)
        // 返回boolean，表示是否添加成功（ArrayList一定会添加成功）
        ArrayList<String> list = new ArrayList<>();
        list.add("李小龙");
        list.add("成龙");
        // 把原位置的元素往后面挤
        list.add(1, "李连杰");
        list.add(1, "甄子丹");
        System.out.println(list);

        // <M> get(int index)
        System.out.println(list.get(1));

        // <M> remove(int index)
        // 返回被删除的元素
        // <M> remove(Object o)
        // 返回boolean是否成功
        String rm = list.remove(0);
        System.out.println(list);
        System.out.println(rm);

        boolean rm2 = list.remove("甄子丹");
        System.out.println(list);
        System.out.println(rm2);

        // <M> size();
        int size = list.size();
        System.out.println(size);

        for (int i = 0; i < size; i++) {
            System.out.println(list.get(i));
        }

        ArrayList<Integer> list2 = new ArrayList<>();
        Random rd = new Random();
        for (int i = 0; i < 20; i++) {
            int num = rd.nextInt(100);
            list2.add(num);
        }
        ArrayList<Integer> list3 = method(list2);
        System.out.println(list3);
    }
    public static ArrayList<Integer> method(ArrayList<Integer> list){
        System.out.println("=======================");
        System.out.println(list);
        ArrayList<Integer> rlist = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int item = list.get(i);
            if(item % 2 == 0){
                rlist.add(item);
            }
        }
        return rlist;
    }
}
