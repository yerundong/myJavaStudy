package 连接数据库;

import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Base {
    /**
     * @ 方式一
     * 缺点：出现了第三方数据库的API：com.mysql.jdbc.Driver
     */
    @Test
    public void connect1() {
        try {
            //1.实例化Driver实现类
            Driver driver = new com.mysql.jdbc.Driver();

            //2.提供url，指明具体操作的数据
            String url = "jdbc:mysql://localhost:3306/test_db?characterEncoding=utf-8";

            //3.提供Properties的对象，指明用户名和密码
            Properties info = new Properties();
            info.setProperty("user", "root");
            info.setProperty("password", "admin");

            //4.调用driver的connect()，获取连接对象
            Connection connect = driver.connect(url, info);
            System.out.println(connect);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * @ 方式二：使用反射
     * 体现了面向接口编程思想
     */
    @Test
    public void connect2() {
        try {
            //1.实例化Driver实现类
            String className = "com.mysql.jdbc.Driver";
            Class clazz = Class.forName(className);
            Constructor<Driver> constructor = clazz.getConstructor();
            Driver driver = constructor.newInstance();

            //2.提供url、Properties的对象（用户名和密码）
            String url = "jdbc:mysql://localhost:3306/test_db?characterEncoding=utf-8";
            Properties info = new Properties();
            info.setProperty("user", "root");
            info.setProperty("password", "admin");

            //3.调用driver的connect()，获取连接对象
            Connection conn = driver.connect(url, info);
            System.out.println(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @ 方式三：反射+DriverManager
     * 使用DriverManager实现数据库的连接
     */
    @Test
    public void connect3() {
        try {
            // 1.实例化Driver实现类
            String className = "com.mysql.jdbc.Driver";
            Class clazz = Class.forName(className);
            Constructor<Driver> ctr = clazz.getConstructor();
            Driver driver = ctr.newInstance();

            // 2.注册驱动
            DriverManager.registerDriver(driver);

            //3.提供用url、户名、密码
            String url = "jdbc:mysql://localhost:3306/test_db?characterEncoding=utf-8";
            String user = "root";
            String password = "admin";

            //4.获取连接
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @ 方式四：反射+DriverManager（省略注册）
     * 不必显式的注册驱动了。因为在DriverManager的源码中已经存在静态代码块中，加载的时候已实现了驱动的注册。
     */
    @Test
    public void connect4() {
        try {
            // 1.加载Driver（com.mysql.jdbc.Driver静态代码快中会自动注册）
            // MySQL这一步其实也可以省略，但是不建议，因为其他数据库不一定可以省略
            Class.forName("com.mysql.jdbc.Driver");

            //2.提供用url、户名、密码
            String url = "jdbc:mysql://localhost:3306/test_db?characterEncoding=utf-8";
            String user = "root";
            String password = "admin";

            //3.获取连接
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @ 方式五：反射+DriverManager+配置文件（最终版）
     * 使用配置文件的好处：
     * ①实现了代码和数据的分离，如果需要修改配置信息，直接在配置文件中修改，不需要深入代码
     * ②如果只修改了配置信息，可以省去重新编译的过程。
     */
    @Test
    public void connect5() {
        try {
            // 1.读取配置，提供用url、户名、密码、Driver实现全类名
            Properties properties = new Properties();
            FileReader fileReader = new FileReader("JDBC/src/lib/jdbc.properties");
            properties.load(fileReader);
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            String url = properties.getProperty("url");
            String driverClass = properties.getProperty("driverClass");

            // 2.加载Driver（com.mysql.jdbc.Driver静态代码快中会自动注册）
            // MySQL这一步其实也可以省略，但是不建议，因为其他数据库不一定可以省略
            Class.forName(driverClass);

            // 3.获取连接
            Connection conn = DriverManager.getConnection(url, user, password);

            System.out.println(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
