package 注解.元注解;

import java.lang.annotation.*;

/*
 @元注解： 用于修饰其他注解的注解

 @四个元注解：
    1.@Retention - 标识这个注解怎么保存，是只在代码中，还是编入class文件中，或者是在运行时可以通过反射访问。
        @参数： RetentionPolicy：枚举，SOURCE/CLASS（没有使用RetentionPolicy，默认这个）/RUNTIME（只有通过RUNTIME才能使用反射获取）

    2.@Documented - 标记这些注解是否包含在用户文档（javadoc）中。
        @无参

    3.@Target - 用于标记这个注解应该是哪种 Java 成员。若没有使用RetentionPolicy默认所有类型都可以使用该注解。
        @参数： ElementType[]：枚举数组

    4.@Inherited - 标记这个注解是继承于哪个注解类(默认 注解并没有继承于任何子类)
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Base {
}
