package 类;

/*
   注意事项：
    1.一个Java源文件中可以有多个类，但只能有一个public的类，并且public的类名必须与文件名相一致。
    2.一个文件中可以有多个非public类，且可以跟文件名不同。
    3.一个包下不能有重复名称的类。
*/
public class Base {
    public static void main(String[] args) {
        People people = new People();
        System.out.println(people.name1);
    }
}

class People {
    String name1 = "郭靖";
    private String name2 = "黄蓉";
    public String name3 = "杨过";
}
