package 字符串.练习;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @Description TODO
 */
public class 不可变性考题 {
    private String str = new String("immutable");
    private String[] strArr = new String[]{"to", "careful", "of"};

    private void change(String s, String[] a){
        s = "variable";
        a[0] = "be";
        a[0] = a[0].concat("ing");
    }

    @Test
    public void test(){
        change(str, strArr);
        System.out.println(str);// immutable
        System.out.println(Arrays.toString(strArr));// [being, careful, of]
    }
}
