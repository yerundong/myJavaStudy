package 集合框架.Vector;

import java.util.Vector;

/**
@Vector: Vector 类可以实现可增长的对象数组。与数组一样，它包含可以使用整数索引进行访问的组件。
    但是，Vector 的大小可以根据需要增大或缩小，以适应创建 Vector 后进行添加或移除项的操作。
 */
public class Base {
    public static void main(String[] args) {
        Vector vector = new Vector();
        vector.add(1);
        vector.add(10.5);
        vector.add("aaa");
        // System.out.println(vector);

        int i = 0;
        for (;;) {
            i++;
            System.out.println(i);
            if(i>20){
                break;
            }

        }
    }
}
