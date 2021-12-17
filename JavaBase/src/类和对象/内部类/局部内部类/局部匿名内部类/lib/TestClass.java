package 类和对象.内部类.局部内部类.局部匿名内部类.lib;

public abstract class TestClass {
    public abstract void says();

    // 局部内部类常见用法
    public Comparable getComparable() {

        // 具名写法
        // class MyComparable implements Comparable {
        //     @Override
        //     public int compareTo(Object o) {
        //         return 0;
        //     }
        // }
        //
        // return new MyComparable();

        // 匿名写法
        return new Comparable() {
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        };

    }
}
