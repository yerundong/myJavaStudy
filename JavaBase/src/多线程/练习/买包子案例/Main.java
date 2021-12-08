package 多线程.练习.买包子案例;

public class Main {
    public static void main(String[] args) {
        new Thread("顾客") {
            @Override
            public void run() {
                while (true) {
                    synchronized (Main.class) {
                        Main.class.notify();

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        System.out.println(currentThread().getName() + "：我要买包子，买包子老板！");

                        try {
                            Main.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        System.out.println(currentThread().getName() + "：再见，老板！");

                        Main.class.notify();

                        try {
                            Main.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (Main.class) {
                        Main.class.notify();

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        System.out.println(Thread.currentThread().getName() + "：好嘞！请稍等！");

                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        System.out.println(Thread.currentThread().getName() + "：（3s后）好了，给您包子！");

                        try {
                            Main.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        System.out.println(Thread.currentThread().getName() + "：再见，上帝！");

                        Main.class.notify();

                        try {
                            Main.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, "包子铺老板").start();
    }
}
