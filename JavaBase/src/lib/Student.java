package lib;

public class Student extends Person {

    private int grade = 1;

    public Student() {
    }

    public Student(String name) {
        super(name);
    }

    public Student(String name, int age, byte sex, int grade) {
        super(name, age, sex);
        this.grade = grade;
    }

    public void study() {
        System.out.println("学生，学习");
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
