package 类和对象.抽象;

/**
 * @Description 抽象类
 */
public abstract class AbsClass1 {
    private int num;

    // 抽象类虽然不能实例化，但仍需要构造器，供子类调用
    public AbsClass1() {
    }

    public AbsClass1(int num) {
        this.num = num;
    }

    // 抽象方法
    public abstract void says();

    // 抽象方法
    public abstract void run();

    // 具体方法
    public void beat(){
        System.out.println("beat");
    };

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    // 抽象成员内部类
    abstract class AbsInsideClass {
        public abstract void joke();

        public  void fanny(){

            // 抽象局部内部类
            abstract class AbsInsideMthClass {

            }

        };
    }
}

