package 值与址的等同判断;

import java.util.Objects;

/*
重写 equals 方法
*/

public class OverrideEquals {
    private String name;
    private int age;

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
