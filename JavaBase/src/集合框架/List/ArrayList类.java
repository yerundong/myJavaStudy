package 集合框架.List;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayList类 {

    /**
     * @数组转ArrayList
     */
    @Test
    public void arrayToArrayList() {
        Integer[] arr1 = {1, 2, 3};
        List<Integer> ls = Arrays.asList(arr1);
        ArrayList<Integer> al = new ArrayList<>(ls);
        System.out.println(al);
    }
}
