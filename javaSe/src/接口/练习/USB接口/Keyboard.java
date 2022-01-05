package 接口.练习.USB接口;

public class Keyboard implements USB {
    @Override
    public void open() {
        System.out.println("使用键盘");
    }

    @Override
    public void close() {
        System.out.println("关闭键盘");
    }

    public void type(){
        System.out.println("键盘输入");
    }
}
