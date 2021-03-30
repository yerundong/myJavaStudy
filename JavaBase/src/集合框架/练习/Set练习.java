package 集合框架.练习;

import org.junit.jupiter.api.Test;
import 示例.Person;

import java.util.HashSet;

public class Set练习 {
    @Test
    public void main(){
        Person p1 = new Person("AA", 25);
        Person p2 = new Person("BB", 25);
        HashSet hashSet = new HashSet();
        hashSet.add(p1);
        hashSet.add(p2);
        System.out.println(hashSet);

        p1.setName("AAA");
        hashSet.remove(p1);// 无法删除成功，因为hashCode和添加时储存的不一样了
        System.out.println(hashSet);

        hashSet.add(new Person("AAA", 25));
        System.out.println(hashSet);// 添加成功，同样因为hashCode和添加时储存的不一样了

        hashSet.add(new Person("AA", 25));
        System.out.println(hashSet);// 添加成功，虽然hashCode和添加时储存的一样了，但是equals不一样
    }
}
