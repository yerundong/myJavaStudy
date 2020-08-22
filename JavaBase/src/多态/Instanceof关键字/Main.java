package 多态.Instanceof关键字;

/*
@ instanceof关键字：用来测试一个对象是否为一个类的实例，或一个对象是否为一个接口的实现实例

@ 格式：boolean bool = object instanceof class/interface
*/
public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Animal animal = new Dog();

        boolean bool = dog instanceof Dog;

        System.out.println(dog instanceof Dog);
        System.out.println(animal instanceof Dog);
        System.out.println(animal instanceof Animal);
        System.out.println(dog instanceof Interface1);
        System.out.println(cat instanceof Cat);


    }
}
