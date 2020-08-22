package 多态.Instanceof关键字;

public class Dog extends Animal implements Interface1 {
    @Override
    public void eat() {
        System.out.println("狗吃骨头");
    }

    public void watchHouse() {
        System.out.println("狗看家");
    }
}