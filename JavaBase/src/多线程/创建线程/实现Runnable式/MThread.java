package 多线程.创建线程.实现Runnable式;

public class MThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "---" + i);
        }
    }
}
