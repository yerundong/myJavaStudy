package StreamAPI;

import StreamAPI.lib.Employee;
import lib.Person;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class 中间操作 {
    /**
     * @筛选
     */
    @Test
    public void filter() {
        // <M> Stream<T> filter(Predicate<? super T> predicate);
        // <返> 筛选
        List<Person> ls = Employee.getEmployee();
        Stream<Person> stream = ls.stream();
        // 筛选出年龄大于40的
        Stream<Person> fs = stream.filter(p -> p.getAge() > 40);
        fs.forEach(System.out::println);
    }

    /**
     * @截断
     */
    @Test
    public void limit() {
        // <M> Stream<T> limit(long maxSize);
        // <返> 截断到前maxSize个
        List<Person> ls = Employee.getEmployee();
        Stream<Person> stream = ls.stream();
        Stream<Person> limit = stream.limit(3);
        limit.forEach(System.out::println);
    }

    /**
     * @跳过
     */
    @Test
    public void skip() {
        // <M> Stream<T> skip(long n);
        // <返> 跳过前 n 个，若不足n个，返回空流
        List<Person> ls = Employee.getEmployee();
        Stream<Person> stream = ls.stream();
        Stream<Person> limit = stream.skip(3);
        limit.forEach(System.out::println);
    }

    /**
     * @去重
     */
    @Test
    public void distinct() {
        // <M> Stream<T> distinct();
        // <返> 根据 hashCode和equals 去除重复元素
        List<Person> ls = Employee.getEmployee();
        ls.add(new Person("马云", 56));
        Stream<Person> stream = ls.stream();
        Stream<Person> distinct = stream.distinct();

        distinct.forEach(System.out::println);
    }

    /**
     * @映射
     */
    @Test
    public void map() {
        // <M> <R> Stream<R> map(Function<? super T, ? extends R> mapper);
        // <返> 映射
        List<Person> ls = Employee.getEmployee();
        Stream<String> s1 = ls.stream().map(p -> p.getName());
        s1.forEach(System.out::println);

        Stream<Integer> s2 = ls.stream().map(Person::getAge);
        s2.forEach(System.out::println);

        // mapToDouble\mapToInt\mapToLong
        ls.stream().mapToDouble(Person::getAge).forEach(System.out::println);

    }

    /**
     * @平铺映射
     */
    @Test
    public void flatMap() {
        // <M> <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper);
        // <返> 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流

        // 一个嵌套的流，类似于嵌套数组[[123]]
        Stream<Stream<Integer>> s1 = Stream.of(Stream.of(1, 2, 3), Stream.of(4, 5, 6), Stream.of(7));
        Stream<Integer> s2 = s1.flatMap(s -> s);
        s2.forEach(System.out::println);


        // 多维数组平铺
        // ArrayList al1 = new ArrayList();
        // al1.add(1);
        // al1.add(2);
        // al1.add(3);
        // ArrayList al2 = new ArrayList();
        // al2.add(al1);
        // al2.add(4);
        //
        // System.out.println(al2);
        //
        // al2.stream().flatMap(s -> {
        //     if (s instanceof List) {
        //         return ((List) s).stream();
        //     } else {
        //         return Stream.of(s);
        //     }
        // }).forEach(System.out::println);
    }

    @Test
    public void testFlatMap() {
        // 对给定单词列表 ["Hello","World"],你想返回列表["H","e","l","o","W","r","d"]
        String[] strs = {"Hello", "World"};
        Arrays.stream(strs).flatMap(s -> Arrays.stream(s.split(""))).forEach(System.out::println);
    }

    /**
     * @Description 排序
     */
    @Test
    public void sorted() {
        // 自然排序
        // <M> Stream<T> sorted();
        List<Person> ls = Employee.getEmployee();
        ls.stream().sorted().forEach(System.out::println);

        // 定制排序
        // <M> Stream<T> sorted(Comparator<? super T> comparator);
        ls.stream().sorted(Comparator.comparingInt(p -> p.getName().length())).forEach(System.out::println);
    }
}
