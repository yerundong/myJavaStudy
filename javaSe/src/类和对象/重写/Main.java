package 类和对象.重写;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("张三", "男", 15);
        person.says();

        Student student = new Student("李四", "男", 17, "福州一中");
        student.says();
    }
}
