package 集合框架.练习;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class List去重 {
    @Test
    public void main() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(2);
        arrayList.add(3);

        ArrayList arrayList2 = removeDuplication(arrayList);
        System.out.println(arrayList2);
    }

    /**
     * @Description 去重方法
     */
    public ArrayList removeDuplication(Collection c) {
        HashSet hashSet = new HashSet();
        hashSet.addAll(c);
        ArrayList arrayList = new ArrayList(hashSet);
        return arrayList;
    }
}
