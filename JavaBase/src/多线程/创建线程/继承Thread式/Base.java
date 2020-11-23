package 多线程.创建线程.继承Thread式;

/**
 @方式： 创建 Thread 子类：SubThread，SubThread实例化几次，就创建几个线程

 @具体步骤：
     1.创建 Thread 子类：SubThread（注：如果子类只用一次，可使用匿名子类）
     2.重写 run 方法
     3.创建 SubThread 实例
     4.实例调用 start 方法

*/
public class Base {
    public static void main(String[] args) {
        Thread.currentThread().setName("主线程");

        SubThread subThread= new SubThread("-分线程");

        subThread.start();

        // @如果线程类只用一次，可使用匿名子类
        new Thread("SubThread2"){
            @Override
            public void run() {
                // ...
            }
        }.start();

    }
}
