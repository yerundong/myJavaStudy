package JDBC.连接数据库;

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
     * @方式一
     */
    @Test
    public void connect1() {
        try {
            Driver driver = new com.mysql.jdbc.Driver();

            String url = "jdbc:mysql://localhost:3306/test_db?characterEncoding=utf-8";
            Properties info = new Properties();
            info.setProperty("user", "root");
            info.setProperty("password", "admin");

            Connection connect = driver.connect(url, info);
            System.out.println(connect);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * @方式二：使用反射
     */
    @Test
    public void connect2() {
        try {
            //1.实例化Driver
            String className = "com.mysql.jdbc.Driver";
            Class clazz = Class.forName(className);
            Driver driver = (Driver) clazz.newInstance();

            //2.提供url，指明具体操作的数据
            String url = "jdbc:mysql://localhost:3306/test_db?characterEncoding=utf-8";

            //3.提供Properties的对象，指明用户名和密码
            Properties info = new Properties();
            info.setProperty("user", "root");
            info.setProperty("password", "admin");

            //4.调用driver的connect()，获取连接
            Connection conn = driver.connect(url, info);
            System.out.println(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @方式三：使用反射+DriverManager
     */
    @Test
    public void connect3() {
        try {
            // 1.实例化Driver
            String className = "com.mysql.jdbc.Driver";
            Class clazz = Class.forName(className);
            Constructor<Driver> ctr = clazz.getConstructor();
            Driver driver = ctr.newInstance();

            // 2.注册驱动
            DriverManager.registerDriver(driver);

            //3.获取连接
            String url = "jdbc:mysql://localhost:3306/test_db?characterEncoding=utf-8";
            Connection conn = DriverManager.getConnection(url, "user", "admin");
            System.out.println(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @方式四：使用反射+DriverManager
     */
    @Test
    public void connect4() {
        try {
            // 1.加载Driver（com.mysql.jdbc.Driver静态代码快中会自动注册）
            Class.forName("com.mysql.jdbc.Driver");

            //2.获取连接
            String url = "jdbc:mysql://localhost:3306/test_db?characterEncoding=utf-8";
            Connection conn = DriverManager.getConnection(url, "user", "admin");
            System.out.println(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @方式五：最终版
     */
    @Test
    public void connect5() {
        try {
            // 1.取配置
            Properties properties = new Properties();
            FileReader fileReader = new FileReader("jdbc.properties");
            properties.load(fileReader);
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            String url = properties.getProperty("url");
            String driverClass = properties.getProperty("driverClass");

            // 2.加载Driver（com.mysql.jdbc.Driver静态代码快中会自动注册）
            Class.forName(driverClass);

            // 3.获取连接
            Connection conn = DriverManager.getConnection(url, user, password);

            System.out.println(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
