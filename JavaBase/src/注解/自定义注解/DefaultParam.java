package 注解.自定义注解;

public @interface DefaultParam {
    String[] value() default {"hello"};
    char key() default 'a';
}
