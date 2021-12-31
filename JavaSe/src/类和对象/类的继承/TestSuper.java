package 类和对象.类的继承;

public class TestSuper {
    public String tip = "Vehicle tip";
    public int age = 15;
    private String name;
    private boolean isCarry = true;

    public TestSuper() {
    }

    public TestSuper(String name) {
        this.name = name;
    }

    public Object says (){
        System.out.println("我叫：" + name +"，是一种交通工具" );
        return null;
    }

    public void run (){
        System.out.println("我是父类的run方法" );
    }

    public static void look (){
        System.out.println("我是父类的look方法" );
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCarry() {
        return isCarry;
    }

    public void setCarry(boolean carry) {
        isCarry = carry;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
