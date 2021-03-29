package 示例;

import 比较器.自然排序.Goods;

import java.util.Objects;

public class Person implements Comparable {

    private String name;

    private int age = 1;

    private byte sex = 1;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int age, byte sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public void walk(){
        System.out.println("人，走路");
    }

    @Deprecated
    public void speak(){
        System.out.println("人，说话");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        // System.out.println("Person 的 equals() 执行！");
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getAge() == person.getAge() &&
                getSex() == person.getSex() &&
                Objects.equals(getName(), person.getName());
    }

    @Override
    public int hashCode() {
        // System.out.println("Person 的 hashCode() 执行！");
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + getAge();
        result = 31 * result + (int) getSex();
        return result;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Person){
            Person p = (Person)o;
            return Integer.compare(getAge(), p.getAge());
        }

        throw new RuntimeException("传入的参数非Person对象");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public byte getSex() {
        return sex;
    }

    public void setSex(byte sex) {
        this.sex = sex;
    }


}
