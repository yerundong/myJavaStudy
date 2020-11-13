package 多线程.练习.卖票;

public class Window extends Thread {
    private static int ticket = 100;

    public Window() {
    }

    public Window(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true){
            if(ticket > 0){
                System.out.println(getName() + "余票：" + ticket);
                ticket--;
            }else{
                break;
            }
        }
    }
}
