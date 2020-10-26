package Object类;

import java.util.Objects;

/**
 * @Description 重写引用类型的equals方法，自定义判断机制
 * @Author 叶润东
 * @Date 2020/10/23
 * @Version 1.0
 */
public class OverrideEquals {
    private String name;
    private int age;

    /**
     * @Description ide自动生成（推荐）
     * @Param [o]
     * @Author 叶润东
     * @Date 10:01 2020/10/26
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OverrideEquals)) return false;
        OverrideEquals that = (OverrideEquals) o;
        return getAge() == that.getAge() &&
                getName().equals(that.getName());
    }

    /**
     * @Description 手写
     * @Param [o]
     * @Author 叶润东
     * @Date 10:15 2020/10/23
     * @return boolean
     */
    // @Override
    // public boolean equals(Object o) {
    //     if (this == o) return true;
    //     if (o == null || getClass() != o.getClass()) return false;
    //     OverrideEquals OverrideEquals = (OverrideEquals) o;
    //     return age == OverrideEquals.age &&
    //             Objects.equals(name, OverrideEquals.name);
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
