package 类和对象.类的继承;

public class TestSub extends TestSuper {
    public String tip = "Car tip";
    private String displacement;

    public TestSub() {
        // 默认隐式调用super()
    }

    public TestSub(String name) {
        super(name);
    }

    public TestSub(String name, String displacement) {
        super(name);
        this.displacement = displacement;
        // System.out.println(super.tip);
    }

    @Override
    public String says (){
        System.out.println("我是重写方法！" );
        return "我是重写方法！";
    }

    // 重载父类方法
    public void run (String word){
        System.out.println(word);
    }

    // @Override 报错，static方法不能重写，但可以重载和隐藏
    public static void look (int num){
        System.out.println("我是子类look");
    }

    // this和super的运用
    public void pop (){
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        System.out.println("我的排量是：" + displacement + "，superTip：" + super.tip + "，subTip：" + this.tip);
    }

    public String getDisplacement() {
        return displacement;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

}
