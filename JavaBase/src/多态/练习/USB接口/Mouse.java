package 多态.练习.USB接口;

public class Mouse implements USB {

    @Override
    public void open() {
        System.out.println("使用鼠标");
    }

    @Override
    public void close() {
        System.out.println("关闭鼠标");
    }

    public void click(){
        System.out.println("鼠标点击");
    }
}
