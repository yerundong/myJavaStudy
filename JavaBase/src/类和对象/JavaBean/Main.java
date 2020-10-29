package 类和对象.JavaBean;

/**
@定义： JavaBean是一个遵循特定写法的Java类，是一种Java语言编写的可重用组件，它的方法命名，构造及行为必须符合特定的约定

@约定：
    1. 所有的成员变量私有化（private）
    2. 私有化的属性必须通过public类型的方法（getter和setter）暴露给其他程序，并且方法的命名也必须遵循一定的命名规范。
    3. 必须具有一个公共的(public)无参构造函数；
    4. 这个类应是可序列化的。（比如可以实现Serializable 接口，用于实现bean的持久性）（待学。。。）

 */
public class Main {
    public static void main(String[] args) {
        TestJavaBean star = new TestJavaBean("刘德华", 60);
        System.out.println("name:"+star.getName()+",age:"+star.getAge());
        System.out.println("A year later");
        star.setAge(61);
        System.out.println("name:"+star.getName()+",age:"+star.getAge());
    }
}


