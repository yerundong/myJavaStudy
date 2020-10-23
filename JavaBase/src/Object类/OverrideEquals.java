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
     * @Description 判断成员变量是否相同
     * @Param [o]
     * @Author 叶润东
     * @Date 10:15 2020/10/23
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OverrideEquals OverrideEquals = (OverrideEquals) o;
        return age == OverrideEquals.age &&
                Objects.equals(name, OverrideEquals.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

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
