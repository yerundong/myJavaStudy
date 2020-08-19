package 多态;

public class SuperClass extends GrandPaClass {
    public String name = "SuperClass name";

    @Override
    public void abs() {
        System.out.println("SuperClass abs");
    }

    public void getName(){
        System.out.println(name);
    }
}
