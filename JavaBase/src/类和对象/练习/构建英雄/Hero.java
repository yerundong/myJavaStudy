package 类和对象.练习.构建英雄;

public class Hero {
    private String name;
    private String from;
    private Weapon weapon;

    // 介绍英雄
    public void sketch(){
        System.out.println("我叫" + name + "，我来自" + from + "，我使用的武器是：" + weapon.getName() + "。");
    }

    // 介绍武器
    public void introWeapon(){
        System.out.println(weapon.getName());
    }

    public Hero() {
    }

    public Hero(String name, String from, Weapon weapon) {
        this.name = name;
        this.from = from;
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}
