package 多线程.Thread类创建线程;

public class SubThread extends Thread {

    public SubThread() {
    }
    public SubThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(currentThread().getName() + "---" + i);
        }
    }

}
