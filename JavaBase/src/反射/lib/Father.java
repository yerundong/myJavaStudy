package 反射.lib;

import 示例.Pet;

public class Father<T> {
    public String name;
    protected int age;
    T sex;
    private Pet pet;
    public static String hobby;
    public static final String PLACE = "China";

    public Father(String name) {
        this.name = name;
    }

    public Father(Pet pet) {
        this.pet = pet;
    }

    public void work() {
    }

    protected boolean speak() {
        return true;
    }

    void look() {
    }

    private void watch() {
    }

    public static void run() {
    }
}
