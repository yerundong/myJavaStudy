package myself.service;

/**
 * @Description 枚举类，封装员工的状态
 */
public enum Status {
    FREE("FREE"),// 空闲
    BUSY("BUSY"),// 已加入开发团队
    VOCATION("VOCATION");// 正在休假

    private final String NAME;

    Status(String name) {
        this.NAME = name;
    }

    public String getNAME() {
        return NAME;
    }

    @Override
    public String toString() {
        return NAME;
    }

}
