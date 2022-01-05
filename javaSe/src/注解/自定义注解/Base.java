package 注解.自定义注解;

import 注解.自定义注解.lib.*;

public class Base {

    @NoneParam
    public void noneParams() {
    }

    @OneParam(tip = 1)
    public void OneParam() {
    }

    @OneValueParam("hello")
    public void OneValueParam() {
    }

    @MultiParam(value = {"hi"}, key = 'a')
    public void MultiParam() {
    }

    @DefaultParam
    public void DefaultParam() {
    }
}
