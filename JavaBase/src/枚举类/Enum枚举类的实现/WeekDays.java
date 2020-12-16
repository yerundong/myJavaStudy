package 枚举类.Enum枚举类的实现;

import 示例.USB;

/***
 Enum枚举类跟类一样，可以实现接口，区别在于枚举类可以给实例常量单独重写抽象方法方法

 @注：
    1.调用重写方法，实例的方法优先

 */
public enum WeekDays implements USB {
    MONDAY, WENTHDAY, FRIDAY{
        @Override
        public void connect() {
            System.out.println("我是FRIDAY的connect");
        }
    };

    @Override
    public void connect() {
        System.out.println("我是类的connect");
    }

    @Override
    public void pull() {
        System.out.println("我是类的pull");
    }
}
