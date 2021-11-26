package 运算符.Instanceof;

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
