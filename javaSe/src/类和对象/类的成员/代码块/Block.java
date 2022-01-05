package 类和对象.类的成员.代码块;

public class Block {

    public static void main(String[] args) {
        System.out.println("************* 入口方法执行 ***************");

        Block block1 = new Block();
        Block block2 = new Block();

        System.out.println(block1.getName());
        System.out.println(Block.getInitCount());
    }

    private String name = "default";
    private static int initCount = 0;

    // 静态代码块
    static {
        System.out.println("静态代码块执行1");
        initCount = 1;
    }

    // 实例代码块
    {
        System.out.println("实例代码块执行1");
        name = "默认名";
    }

    public Block() {
        // name = "DEF";
    }

    public Block(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static int getInitCount() {
        return initCount;
    }
}
