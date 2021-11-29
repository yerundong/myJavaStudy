package 枚举类.Enum枚举类实现接口;

import 示例.USB;

public enum WeekDays implements USB {
    MONDAY("星期一", 1),
    TUESDAY("星期二", 2),
    FRIDAY("星期五", 5) {
        @Override
        public void connect() {
            System.out.println("我是FRIDAY的connect");
        }
    };// FRIDAY实例是由匿名的WeekDays子类创建，并向上转型为 WeekDays 类。所以此处只能不能定义“独有”的方法，这是由多态的性质决定的。

    private String name;
    private int code;

    WeekDays(String name, int code) {
        this.name = name;
        this.code = code;
    }

    @Override
    public void connect() {
        System.out.println("我是类的connect");
    }

    @Override
    public void pull() {
        System.out.println("我是类的pull");
    }
}
