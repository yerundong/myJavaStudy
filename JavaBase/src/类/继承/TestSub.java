package 类.继承;

public class TestSub extends TestSuper {
    public String tip = "Car tip";
    private String displacement;

    public TestSub() {
        // 无参会隐式调用super()
    }

    public TestSub(String name) {
        // 有参必须显式调用super()，并且必须第一执行
        super(name);
    }

    public TestSub(String name, String displacement) {
        // 有参必须显式调用super()，并且必须第一执行
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
        System.out.println("我的排量是：" + displacement + "，superTip：" + super.tip + "，subTip：" + this.tip);
    }

    public String getDisplacement() {
        return displacement;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }
}
