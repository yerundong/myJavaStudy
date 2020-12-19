package 注解.内置注解;

import 示例.Person;

import java.util.ArrayList;

/**

 */
public class Base extends Person {
    // @Override：重写，可写可不写，建议写，可校验是否重写
    @Override
    public void walk() {
        super.walk();
    }

    // @Deprecated：过时、已弃用，意味将来很可能被删除，使用时会被划线，但仍可正常使用
    @Deprecated
    public void deprecated(){
        System.out.println("我是deprecated");
    }

    // @SuppressWarnings：抑制编译器警告
    // 放这里可以作用整个方法
    // @SuppressWarnings({"unused", "rawtypes"})
    public void suppressWarnings(){

        @SuppressWarnings("unused")
        // 只会作用第一个
        int num1 = 10;
        int num2 = 10;

        @SuppressWarnings({"unused", "rawtypes"})
        ArrayList arrayList = new ArrayList();
    }

}
