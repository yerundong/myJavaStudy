package 类和对象.练习.复习类;

public class Main {
    public static void main(String[] args) {
        Man.whatCanISay();

        Man man1 = new Man();
        man1.introduction();

        Man man2 = new Man("张三", 12);
        man2.introduction();

        man2.addAge(2);
        man2.introduction();
    }
}
