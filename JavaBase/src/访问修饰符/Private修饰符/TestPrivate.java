package 访问修饰符.Private修饰符;

// private class TestPrivate {}// 报错，不能修饰外部类

public class TestPrivate {
    int age = 15;
    // 成员变量
    private String name = "闪电侠";
    public String frient = "超人";
    private boolean male;

    public void say(){
        System.out.println("age:" + age +",name:" + name + ",frient:" + frient);
    }

    public void executeAxiba(){
        this.axiba();
    }

    // 修饰成员方法
    private void axiba(){
        System.out.println("axiba!!!");
    }

    public void setName(String newName){
        name = newName;
    }

    public String getName(){
        return name;
    }

    public void setMale(boolean b) {
        male = b;
    }

    public boolean isMale() {
        return male;
    }

    // 修饰内部类
    private class Axiba {}// 等学了内部类再来补。。。
}

