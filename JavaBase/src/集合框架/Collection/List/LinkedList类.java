package 集合框架.Collection.List;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class LinkedList类 {
    @Test
    public void test() {
        LinkedList<Character> ll = new LinkedList<>();
        ll.add('a');
        ll.add('b');
        ll.add('c');
        System.out.println(ll);
        System.out.println(ll.get(1));
    }
}
