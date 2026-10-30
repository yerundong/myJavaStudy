package 类和对象.重写;

public class Student extends Person {
    private String schoolName;
    public Student(String name, String sex, int age, String schoolName) {
        super(name, sex, age);
        this.schoolName = schoolName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override
    public void says() {
        System.out.println("我是学生, 我叫"+getName()+"，性别是"+getSex()+"，年龄是"+getAge()+"，我在"+schoolName+"上学");
    }
}
