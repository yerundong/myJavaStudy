package 类和对象.练习.构建英雄;

public class Main {
    public static void main(String[] args) {
        Hero gaylon = new Hero("盖伦", "德玛西亚", new Weapon("暴风大剑"));
        gaylon.sketch();
        gaylon.introWeapon();
    }
}
