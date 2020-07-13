package 类;

public class Student {
    String name = "ZhangSan";
    int age = 18;

    public void say(){
        System.out.println("I am "+this.name+",I am "+this.age + " years old.");
    }

    public void friend(String name){
        System.out.println("My friend is "+name+".");
    }
}
