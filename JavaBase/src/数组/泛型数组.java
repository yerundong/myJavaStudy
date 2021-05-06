package 数组;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class 泛型数组 {
    /**
     * 参考链接：https://www.cnblogs.com/ixenos/p/5648519.html
     */
    @Test
    public void test(){
        List<String>[] arr = (List<String>[])new List[1];
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arr[0] = arrayList;
    }
}
