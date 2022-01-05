package 多线程.线程优先级;

public class Base {
    public static void main(String[] args) {
        // 主线程优先级
        Thread.currentThread().setPriority(7);

        MyThread myThread1 = new MyThread("线程1");
        MyThread myThread2 = new MyThread("线程2");

        myThread1.start();

        // @setPriority
        myThread2.setPriority(Thread.MAX_PRIORITY);
        myThread2.start();

        // @getPriority
        System.out.println("main优先级:" + myThread2.getPriority());
        System.out.println("myThread1优先级:" + myThread1.getPriority());
        System.out.println("myThread2优先级:" + myThread2.getPriority());

        for (int i = 0; i < 10; i++) {
            System.out.println("我是主线程" + i);
        }
    }
}
