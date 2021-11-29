package 枚举类.Enum枚举类实现接口;

public class Test {
    public void test() {
        WeekDays.MONDAY.connect();
        WeekDays.FRIDAY.connect();// FRIDAY实例是由匿名的WeekDays子类创建，属于FRIDAY的单独的重写方法
        WeekDays.TUESDAY.pull();
    }
}
