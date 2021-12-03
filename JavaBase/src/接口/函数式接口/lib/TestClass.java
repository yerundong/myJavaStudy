package 接口.函数式接口.lib;

public class TestClass {
    private String name;
    private int age;

    public TestClass() {
    }

    public TestClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void look() {
        System.out.println("look");
    }

    public void see(String s) {
        System.out.println(s);
    }

    public String check() {
        return "check";
    }

    public String watch(String s) {
        return s;
    }

    public String read(int i) {
        return "i";
    }

    public String view(String s, int i) {
        return s + i;
    }

    @Override
    public String toString() {
        return "TestClass{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TestClass)) return false;

        TestClass testClass = (TestClass) o;

        if (getAge() != testClass.getAge()) return false;
        return getName() != null ? getName().equals(testClass.getName()) : testClass.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + getAge();
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
