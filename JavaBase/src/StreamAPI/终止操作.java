package StreamAPI;

import StreamAPI.lib.Employee;
import org.junit.jupiter.api.Test;
import 示例.Person;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 终止操作 {
    /**
     * @迭代
     */
    @Test
    public void forEach() {
        // <M> void forEach(Consumer<? super T> action);
        // <返> 内部迭代(使用 Collection 接口需要用户去做迭代，称为外部迭代。相反，Stream API 使用内部迭代——它帮你把迭代做了)
        List<Person> ls = Employee.getEmployee();
        Stream<Person> stream = ls.stream();
        stream.forEach(System.out::println);
    }

    /**
     * @匹配所有
     */
    @Test
    public void allMatch() {
        // <M> boolean allMatch(Predicate<? super T> predicate);
        // <返> 检查是否匹配所有元素
        List<Person> ls = Employee.getEmployee();
        boolean b = ls.stream().allMatch(p -> p.getAge() > 35);
        System.out.println(b);
    }

    /**
     * @匹配任意
     */
    @Test
    public void anyMatch() {
        // <M> boolean anyMatch(Predicate<? super T> predicate);
        // <返> 检查是否至少匹配一个元素
        List<Person> ls = Employee.getEmployee();
        boolean b = ls.stream().anyMatch(p -> p.getAge() < 35);
        System.out.println(b);
    }

    /**
     * @没有匹配所有
     */
    @Test
    public void noneMatch() {
        // <M> boolean noneMatch(Predicate<? super T> predicate);
        // <返> 检查是否没有匹配所有元素
        List<Person> ls = Employee.getEmployee();
        boolean b = ls.stream().noneMatch(p -> p.getAge() > 1000);
        System.out.println(b);
    }

    /**
     * @第一个元素
     */
    @Test
    public void findFirst() {
        // <M> Optional<T> findFirst();
        // <返> 返回第一个元素
        List<Person> ls = Employee.getEmployee();
        Optional<Person> first = ls.stream().findFirst();
        System.out.println(first);
    }

    /**
     * @任意元素
     */
    @Test
    public void findAny() {
        // <M> Optional<T> findAny();
        // <返> 返回当前流中的任意元素
        // 可以看到findAny()操作，返回的元素是不确定的，对于同一个列表多次调用 findAny()有可能会返回不同的值。
        // 使用findAny()是为了更高效的性能。如果是数据较少，串行地情况下，一般会返回第一个结果，如果是并行的情况，那就不能确保是第一个。
        List<Person> ls = Employee.getEmployee();
        // Optional<Person> any = ls.stream().findAny();
        Optional<Person> any = ls.parallelStream().findAny();
        System.out.println(any);
    }

    /**
     * @总数
     */
    @Test
    public void count() {
        // <M> long count();
        // <返> 返回流中元素总数
        List<Person> ls = Employee.getEmployee();
        long count = ls.stream().count();
        System.out.println(count);
    }

    /**
     * @最大值
     */
    @Test
    public void max() {
        // <M> Optional<T> max(Comparator<? super T> comparator);
        // <返> 返回流中最大值
        List<Person> ls = Employee.getEmployee();
        Optional<Person> max = ls.stream().max(Comparator.comparingInt(Person::getAge));
        System.out.println(max);
    }

    /**
     * @最小值
     */
    @Test
    public void min() {
        // <M> Optional<T> min(Comparator<? super T> comparator);
        // <返> 返回流中最小值
        List<Person> ls = Employee.getEmployee();
        Optional<Person> min = ls.stream().min(Comparator.comparingInt(Person::getAge));
        System.out.println(min);
    }

    /**
     * @归约
     */
    @Test
    public void reduce() {
        // <M> Optional<T> reduce(BinaryOperator<T> accumulator);
        // <M> T reduce(T identity, BinaryOperator<T> accumulator);
        // <返> identity是初始值
        List<Integer> ls = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Integer reduce1 = ls.stream().reduce(0, Integer::sum);
        Integer reduce2 = ls.stream().reduce(1, (i1, i2) -> i1 * i2);
        Optional<Integer> reduce3 = ls.stream().reduce(Integer::sum);

        System.out.println(reduce1);
        System.out.println(reduce2);
        System.out.println(reduce3);
    }

    /**
     * @收集
     */
    @Test
    public void collect() {
        List<Person> ls = Employee.getEmployee();
        List<Person> collect1 = ls.stream().collect(Collectors.toList());
        Set<Person> collect2 = ls.stream().collect(Collectors.toSet());
        Long count = ls.stream().collect(Collectors.counting());
        IntSummaryStatistics collect3 = ls.stream().collect(Collectors.summarizingInt(Person::getAge));
        System.out.println(count);
        System.out.println(collect3);
    }
}
