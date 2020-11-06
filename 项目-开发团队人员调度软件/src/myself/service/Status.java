package myself.service;

/**
 * @Description 枚举类（待学），封装员工的状态
 */
public class Status {

    private final String NAME;

    private Status(String name) {
        this.NAME = name;
    }

    public static final Status FREE = new Status("FREE");// 空闲
    public static final Status BUSY = new Status("BUSY");// 已加入开发团队
    public static final Status VOCATION = new Status("VOCATION");// 正在休假

    public String getNAME() {
        return NAME;
    }

    @Override
    public String toString() {
        return NAME;
    }

}
