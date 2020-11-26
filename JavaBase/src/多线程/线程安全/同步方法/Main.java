package 多线程.线程安全.同步方法;

/**
 @同步方法格式：
     synchronized returnType methodName(){
        // 需要同步的代码
     }

 @同步监视器（锁）： 无法手动声明，是固定的。若同步方法是实例的，便是 this 对象，若是静态的，便是本类的class属性（class文件对象）
    @注： 当在【继承式创建的线程】中想要使用同步方法来实现线程同步，则需要使用【静态的同步方法】

 @注意事项：
    1.synchronized关键字不能继承：在父类中的某个方法使用了synchronized关键字，而在子类中覆盖了这个方法，
    在子类中的这个方法默认情况下并不是同步的，而必须显式地在子类的这个方法中加上synchronized关键字才可以。
 */
public class Main {
    public static void main(String[] args) {
        Thread rw1 = new Window("窗口一");
        Thread rw2 = new Window("窗口二");
        Thread rw3 = new Window( "窗口三");

        rw1.start();
        rw2.start();
        rw3.start();
    }
}
