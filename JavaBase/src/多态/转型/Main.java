package 多态.转型;

public class Main {
    public static void main(String[] args) {
        // 向上转型
        Animal animal = new Cat();
        animal.eat();// 猫吃鱼
        // animal.catchMouse();// 报错（动物一定会吃，但不一定会捉老鼠）

        // 向下转型
        Cat cat = (Cat) animal;
        cat.catchMouse();// 还原成猫才捉老鼠

        // 本来是猫，扩大到动物，还原时也只能还原为猫，不能还原为狗
        // 报错：java.lang.ClassCastException（类强制转换异常）
        Dog dog = (Dog) animal;
        dog.eat();
        dog.watchHouse();

        // 没有多态，不能向下转型
        Dog dog2 = new Dog();
        // RedDog rd = (RedDog)dog;// ClassCastException
        // RedDog rd = (RedDog)dog2;// ClassCastException
    }
}
