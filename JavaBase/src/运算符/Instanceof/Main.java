package 运算符.Instanceof;

/*
@ instanceof 运算符：用来测试一个对象是否为一个类或其子类的实例，或一个对象是否为一个接口或其子接口的实现实例，返回boolean值

@ 格式：boolean bool = object instanceof Class/Interface
*/
public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Animal animal = new Animal();
        Animal anidog = new Dog();

        boolean bool = dog instanceof Dog;

        System.out.println(dog instanceof Dog);// true
        System.out.println(dog instanceof Animal);// true
        System.out.println(anidog instanceof Dog);// true
        System.out.println(anidog instanceof Animal);// true

        System.out.println(animal instanceof Dog);// false，animal是其父类的实例
        System.out.println(dog instanceof Interface1);// true
        // System.out.println(cat instanceof Dog);// true，编译报错，不兼容类型
    }
}
