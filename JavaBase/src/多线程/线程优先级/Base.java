package 多线程.线程优先级;
/**
 @优先级: java中的线程优先级的范围是1～10，默认的优先级是5。“高优先级线程”会优先于“低优先级线程”执行（概率上）。

 @注： 子线程的优先级被默认等于创建它的主线程的优先级

 @线程优先级（静态属性）：
    1.MAX_PRIORITY：10
    2.MIN_PRIORITY：1
    3.NORM_PRIORITY(默认):5

 @设置\获取优先级： setPriority()\getPriority()

 */
public class Base {
    public static void main(String[] args) {
        // 主线程优先级
        Thread.currentThread().setPriority(5);

        SubThread subThread1 = new SubThread("线程1");
        SubThread subThread2 = new SubThread("线程2");

        subThread2.start();
        // @setPriority
        subThread1.setPriority(SubThread.MAX_PRIORITY);

        subThread1.start();
        subThread2.setPriority(4);

        // @getPriority
        System.out.println("subThread1优先级:" + subThread1.getPriority());
        System.out.println("subThread2优先级:" + subThread2.getPriority());
        System.out.println("main优先级:" + subThread2.getPriority());

        for (int i = 0; i < 10; i++) {
            System.out.println("我是主线程"+i);
        }

        // System.out.println(subThread1.getState());
        // try {
        //     Thread.sleep(1000);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        //
        // System.out.println(subThread1.getState());
        // System.out.println(subThread1.isAlive());
    }
}
