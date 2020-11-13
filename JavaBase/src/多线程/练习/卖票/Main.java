package 多线程.练习.卖票;

public class Main {
    public static void main(String[] args) {
        // 方法一：继承方式
        Window w1 = new Window("窗口一");
        Window w2 = new Window("窗口二");
        Window w3 = new Window("窗口三");

        // w1.start();
        // w2.start();
        // w3.start();


        // 方法一：实现方式
        RWindow rWindow = new RWindow();
        Thread rw1 = new Thread(rWindow, "r窗口一");
        Thread rw2 = new Thread(rWindow, "r窗口二");
        Thread rw3 = new Thread(rWindow, "r窗口三");

        rw1.start();
        rw2.start();
        rw3.start();
    }
}
