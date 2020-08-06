package 修饰符.Static修饰符;

/*
1.static修饰类的属性和方法:
    1.一旦使用static修饰成员属性\方法，就成为了静态属性\方法，它们属于所在的类，非属于实例对象。
    2.同一类的实例对象可以共享该类的静态属性\方法。
    3.实例属性需要new对象才能使用它，静态属性不需要，直接就能通过类名称来使用它。

2.static修饰类:
    1.普通类是不允许声明为静态的，只有内部类才可以

*/
public class Base {
    public static void main(String[] args) {
        Pupil pup1 = new Pupil("郭靖", 18);

        // 静态属性
        pup1.country = "China";
        System.out.println(pup1.country);// 正确，不推荐，这种写法在编译之后也会被javac翻译成为“类名称.静态属性名”
        System.out.println(Pupil.country); // 正确，推荐
        // 静态方法
        pup1.yoxi();// 正确，不推荐 这种写法在编译之后也会被javac翻译成为“类名称.静态方法名”
        Pupil.yoxi(); // 正确，推荐

        pup1.say();
        System.out.println(pup1.getId());
        System.out.println(pup1.getIdCount());

        System.out.println("============================");

        Pupil pup2 = new Pupil("黄蓉", 17);
        pup2.say();
        System.out.println(pup1.getId());

        System.out.println(pup1.getIdCount());
        System.out.println(pup2.getIdCount());
    }
}

class Pupil {
    private String name;
    private int age;
    private int id = 0;

    // 静态属性
    static String country;
    // 私有静态属性
    private static int idCount = 0;

    public Pupil() {
        id = ++idCount;
    }

    public Pupil(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = ++idCount;
    }
    public void say() {
        System.out.println("I am " + this.name + ",I am " + this.age + " years old," +
                "I am from " + this.country+",my id is "+ this.id);
    }

    // 静态方法
    public static void yoxi(){
        System.out.println("I am static method!!!");
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getIdCount() {
        return idCount;
    }

    public static void setIdCount(int idCount) {
        Pupil.idCount = idCount;
    }
}

