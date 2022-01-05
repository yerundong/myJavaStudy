package 泛型.练习.lib;

public class Son extends Father<String, Integer> {

    public Son() {
    }

    public Son(String name, Integer age) {
        super(name, age);
    }
}
