package 多态.转型;

public class Dog extends Animal {
    @Override
    public void eat() {
        System.out.println("狗吃骨头");
    }

    public void watchHouse() {
        System.out.println("狗看家");
    }
}
