package 示例;

/**
 * @Description 物种枚举类
 */
public enum Species {
    DOG("狗"),CAT("猫"),PIG("猪"),DUCK("鸭"),CHICKEN("鸡"),UNKNOWN;

    private String name;

    Species() {
        this.name = "未知物种";
    }

    Species(String name) {
        this.name = name;
    }
}
