package 类;

/*
一个标准的类通常要包含下面四个组成部分：

1. 所有的成员变量都要使用private关键字修饰
2. 为每一个成员变量编写一对儿Getter/Setter方法
3. 编写一个无参数的构造方法
4. 编写一个全参数的构造方法

这样标准的类也叫做Java Bean
 */
public class 标准的类 {
    public static void main(String[] args) {
        Star star = new Star("刘德华", 60);
        System.out.println("name:"+star.getName()+",age:"+star.getAge());
        System.out.println("A year later");
        star.setAge(61);
        System.out.println("name:"+star.getName()+",age:"+star.getAge());
    }
}

class Star{
    private String name;
    private int age;

    public Star() {
    }

    public Star(String name, int age) {
        this.name = name;
        this.age = age;
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
}
