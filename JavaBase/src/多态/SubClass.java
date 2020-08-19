package 多态;

public class SubClass extends SuperClass {
    public String name = "SubClass name";
    public String tip = "SubClass tip";

    @Override
    public void abs() {
        System.out.println("SubClass abs");
    }

    @Override
    public void getName(){
        System.out.println(name);
    }
}
