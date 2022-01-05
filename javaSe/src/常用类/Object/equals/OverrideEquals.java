package 常用类.Object.equals;

import java.util.Objects;

/**
 * @Description 重写equals方法，自定义判等机制
 */
public class OverrideEquals {
    private String name;
    private int age;

    /**
     * @return boolean
     * @Description ide自动生成（区分子类）
     * @Param [o]
     * @Author 叶润东
     * @Date 10:01 2020/10/26
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OverrideEquals that = (OverrideEquals) o;
        return getAge() == that.getAge() &&
                Objects.equals(getName(), that.getName());
    }

    /**
     * @return boolean
     * @Description ide自动生成 不区分子类
     * @Param [o]
     * @Author 叶润东
     * @Date 10:15 2020/10/23
     */
    // @Override
    // public boolean equals(Object o) {
    //     if (this == o) return true;
    //     if (!(o instanceof OverrideEquals)) return false;
    //     OverrideEquals that = (OverrideEquals) o;
    //     return getAge() == that.getAge() &&
    //             Objects.equals(getName(), that.getName());
    // }
    public OverrideEquals(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
