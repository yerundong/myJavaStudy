package 多线程.线程优先级;

public class SubThread extends Thread {

    public SubThread() {
    }
    public SubThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("我是"+getName());
        }
    }
}
