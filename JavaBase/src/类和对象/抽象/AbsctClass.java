package 类和对象.抽象;

public abstract class AbsctClass {
    private int num;

    public AbsctClass() {
    }

    public AbsctClass(int num) {
        this.num = num;
    }

    public abstract void says();

    public abstract void run();

    public  void beat(){
        System.out.println("beat");
    };

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    abstract class Abs{

    }
}

