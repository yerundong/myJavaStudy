package 类和对象.练习.复习类;

public class Man {
    String name;
    int age;

    public Man() {
    }

    public Man(String name) {
        this.name = name;
    }

    public Man(int age) {
        this.age = age;
    }

    public Man(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void whatCanISay() {
        System.out.println("Man! What can I say?");
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void addAge(int year) {
        age = age + year;
    }

    public void introduction() {
        System.out.println("我叫" + name + ",今年" + age + "岁.");
    }
}
