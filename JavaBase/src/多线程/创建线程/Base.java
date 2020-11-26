package 多线程.创建线程;

/**
 @继承式和实现式对比：
    1.实现方式没有单继承性的限制：实际场景中，如果类继承了Thread类就不能继承其他类，而实现无此限制
    2.实现方式更方便处理多个线程共享数据的场景
    3.

 @Callable与Runnable方式对比：
     1.Callable 可以在任务结束的时候提供一个返回值，Runnable 无法提供这个功能
     2.Callable 的 call 方法分可以抛出异常，而 Runnable 的 run 方法不能抛出异常。
     3.Callable 支持泛型

 @结论： 更推荐使用实现式创建线程


 */
public class Base {

}
