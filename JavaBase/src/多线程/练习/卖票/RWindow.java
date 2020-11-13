package 多线程.练习.卖票;

public class RWindow implements Runnable{
    private int ticket = 100;

    @Override
    public void run() {
        while (true){
            if(ticket > 0){
                System.out.println(Thread.currentThread().getName() + "余票：" + ticket);
                ticket--;
            }else{
                break;
            }
        }
    }
}
