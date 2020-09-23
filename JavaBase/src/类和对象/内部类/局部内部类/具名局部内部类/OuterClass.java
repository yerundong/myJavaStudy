package 类和对象.内部类.局部内部类.具名局部内部类;

public class OuterClass {
    int num = 10;
    public void says(){
        int num = 20;
        // num = 10;// 报错，被局部内部类访问无法更改

        // 局部内部类
        class InnerClass{
            // 若局部内部类的成员方法和局部变量重名，则访问不到局部变量了（Naming Shadow）
            // int num = 30;

            public void look(){
                System.out.println("局部内部类执行了");

                System.out.println(num);
                System.out.println(OuterClass.this.num);
            }
        }

        InnerClass innerCla = new InnerClass();
        innerCla.look();
    }
}
