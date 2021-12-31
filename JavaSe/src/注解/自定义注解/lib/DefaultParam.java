package 注解.自定义注解.lib;

public @interface DefaultParam {
    String[] value() default {"hello"};

    char key() default 'a';
}
