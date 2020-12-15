package 枚举类;

/**
 @自定义枚举类：

 @步骤：
    1.声明一个类，在类中声明该枚举类的属性（private final）；
    2.私有化构造器（private），并给属性赋值；
    3.在类中创建枚举实例，并提供公共静态常数的访问方式（public static final）

 @注：
    1.
 */
public class Season {
    // 枚举实例的属性
    private final String seasonName;
    private final String seasonDesc;

    // 枚举实例
    public static final Season SPRING = new Season("春天", "春暖花开");
    public static final Season SUMMER = new Season("夏天", "夏日炎炎");
    public static final Season AUTUMN = new Season("秋天", "秋高气爽");
    public static final Season WINTER = new Season("冬天", "冬天很冷");

    // 构造器
    private Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}
