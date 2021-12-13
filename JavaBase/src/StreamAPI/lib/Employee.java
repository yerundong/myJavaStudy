package StreamAPI.lib;

import 示例.Person;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    public static List<Person> getEmployee() {
        List<Person> ls = new ArrayList<>();
        ls.add(new Person("马云", 56));
        ls.add(new Person("马化腾", 44));
        ls.add(new Person("王健林", 62));
        ls.add(new Person("刘强东", 41));
        ls.add(new Person("王石", 31));
        ls.add(new Person("曹德旺", 70));
        ls.add(new Person("李嘉诚", 91));
        ls.add(new Person("王兴", 32));
        return ls;
    }
}
