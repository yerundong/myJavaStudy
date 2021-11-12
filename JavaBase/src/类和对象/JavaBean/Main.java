package 类和对象.JavaBean;

public class Main {
    public static void main(String[] args) {
        TestJavaBean star = new TestJavaBean("刘德华", 60);
        System.out.println("name:" + star.getName() + ",age:" + star.getAge());
        System.out.println("A year later");
        star.setAge(61);
        System.out.println("name:" + star.getName() + ",age:" + star.getAge());
    }
}


