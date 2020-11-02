package 设计模式.单例模式;

/**
 @单例模式（Singleton）： 单例模式是一种常用的设计模式。该模式能保证在一个 JVM 中，某类只有一个实例存在。例如：java.lang.Runtime

 @好处：
     1、某些类创建比较频繁，对于一些大型的对象，这是一笔很大的系统开销。
     2、省去了 new 操作符，降低了系统内存的使用频率，减轻 GC 压力。
     3、有些类如交易所的核心交易引擎，控制着交易流程，如果该类可以创建多个的话，系统完全乱了。（比如一个军队出现了多个司令员同时指挥，肯定会乱成一团），
        所以只有使用单例模式，才能保证核心交易服务器独立控制整个流程

 @要求：
    1.私有化（private）的构造器
    2.内部创建类的对象，并保证只创建一个
    3.通过静态方法获得实例对象

 @饿汉式和懒汉式：
    1.饿汉式
        坏处：对象加载时间过长
        好处：线程安全
    2.懒汉式（推荐）
        坏处：延迟对象创建
        好处：线程不安全，但可以处理

 @应用场景:
    1.网站的计数器，一般也是单例模式实现，否则难以同步。
    2.应用程序的日志应用，一般都使用单例模式实现，这一般是由于共享的日志文件一直处于打开状态，因为只能有一个实例去操作，否则内容不好追加。
    3.数据库连接池的设计一般也是采用单例模式，因为数据库连接是一种数据库资源。
    4.项目中，读取配置文件的类，一般也只有一个对象。没有必要每次使用配置文件数据，都生成一个对象去读取。
    5.Application 也是单例的典型应用
    6.Windows 的 Task Manager (任务管理器)就是很典型的单例模式
    7.Windows 的 Recycle Bin (回收站)也是典型的单例应用。在整个系统运行过程中，回收站一直维护着仅有的一个实例

 */
public class Base {
    public static void main(String[] args) {

        // new HungrySingleton();// 不可在外部实例化

        HungrySingleton hungry1 = HungrySingleton.getInstance();
        HungrySingleton hungry2 = HungrySingleton.getInstance();
        System.out.println(hungry1 == hungry2);

        LazySingleton lazy1 = LazySingleton.getInstance();
        LazySingleton lazy2 = LazySingleton.getInstance();
        System.out.println(lazy1 == lazy2);
    }
}
