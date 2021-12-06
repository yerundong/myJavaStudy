package 多线程.创建线程.实现Runnable式;

public class Base {
    public static void main(String[] args) {
        
        MyThread myThread = new MyThread();
        Thread thread1 = new Thread(myThread, "@子线程1");
        Thread thread2 = new Thread(myThread, "@子线程2");

        System.out.println(thread1);
        thread1.start();
        thread2.start();
    }
}
