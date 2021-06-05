package Stream;

import org.junit.jupiter.api.Test;
import 示例.Person;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Stream;

public class 创建实例 {
    /**
     * @通过容器（集合、数组）获取Stream实例
     */
    @Test
    public void test1() {
        // 1.集合
        HashSet<Person> hs = new HashSet<>();
        hs.add(new Person("a"));
        hs.add(new Person("b"));
        hs.add(new Person("c"));
        System.out.println(hs);
        Stream<Person> s1 = hs.stream();// 顺序流
        Stream<Person> ps1 = hs.parallelStream();// 并行流

        // 2.数组
        Person[] people = {new Person("c"), new Person("d"), new Person("d")};
        Stream<Person> s2 = Arrays.stream(people);
    }

    /**
     * @通过Stream.of()获取实例
     */
    @Test
    public void test2() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3);
    }

    /**
     * @创建无限流
     */
    @Test
    public void test3() {
        Stream<Integer> s1 = Stream.iterate(0, t -> t + 2).limit(10);
        s1.forEach(System.out::println);

        System.out.println("--------------------------");
        Stream<Double> s2 = Stream.generate(Math::random).limit(10);
        s2.forEach(System.out::println);
    }
}
