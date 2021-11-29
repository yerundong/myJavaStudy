package 权限修饰符.Private修饰符;

public class Main {
    public static void main(String[] args) {
        TestPrivate hero = new TestPrivate();
        hero.age = 20;
        hero.frient = "钢铁侠";

        // private属性不能在类外访问
        // hero.name = "钢铁侠";// 错误

        // 通过setter、getter访问private属性
        hero.setName("蜘蛛侠");
        String getname = hero.getName();

        hero.say();

        // private方法不能在类外调用
        // hero.axiba();// 错误
        hero.executeAxiba();

        hero.setMale(true);
        System.out.println("是爷们儿吗：" + hero.isMale());
    }
}