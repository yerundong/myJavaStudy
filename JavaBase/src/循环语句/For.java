package 循环语句;

import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 *
 */
public class For {
    @Test
    public void normalFor() {
        for (int i = 0; i < 10; i++) {
            // System.out.println(i);
        }

        // 无限制条件
        for (int i = 0; ; i++) {
            // System.out.println(i);
            if(i>15){
                break;
            }
        }

        // 无限循环
        // for (;;) {
        //
        // }
    }

    @Test
    public void strongerFor(){
        // <格式> for (type item : ite)

        // 遍历集合
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        for (int item : arr1) {
            System.out.println(item);
        }

        // 也可以用于遍历集合
        // 底层是用迭代器 Iterator 实现的
        Collection clt = Arrays.asList('a', 123, "gg");
        for (Object o : clt) {
            System.out.println(o);
        }
    }

    @Test
    public void flagFor(){
        a:for (int i = 0; ; i++) {
            b:for (int j = 0; ; j++) {
                System.out.println(i);
                if(j > 5){
                    break a;
                }
            }
        }
    }
}
