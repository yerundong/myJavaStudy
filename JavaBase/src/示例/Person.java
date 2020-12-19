package 示例;

public class Person {

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
