package JDBC.PreparedStatement;

import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.Properties;

public class Base {
    // 获取连接
    public Connection getConnect() {
        Connection conn = null;
        try {
            // 1.取配置
            Properties properties = new Properties();
            FileReader fileReader = new FileReader("JavaBase/src/JDBC/lib/jdbc.properties");
            properties.load(fileReader);
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            String url = properties.getProperty("url");
            String driverClass = properties.getProperty("driverClass");

            // 2.加载Driver（com.mysql.jdbc.Driver静态代码快中会自动注册）
            Class.forName(driverClass);

            // 3.获取连接
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * @查询
     */
    @Test
    public void test_select() {
        String sql = "SELECT `user_id` id, `user_name` name, age, location_id locationId FROM `user` WHERE `user_id` = ?";
        User user = commonQuery(User.class, sql, 2);
        System.out.println(user);
    }

    /**
     * 通用sql查询
     */
    public <T> T commonQuery(Class<T> clazz, String sql, Object... args) {
        Connection connect = getConnect();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        T obj = null;
        try {
            ps = connect.prepareStatement(sql);

            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            resultSet = ps.executeQuery();// 执行获得结果集
            ResultSetMetaData rsmd = ps.getMetaData();// 获取元数据，从而获取列数
            int columnCount = rsmd.getColumnCount();// 从元数据中获取列数

            if (resultSet.next()) {
                Constructor constructor = clazz.getConstructor();
                obj = (T) constructor.newInstance();

                for (int i = 0; i < columnCount; i++) {
                    Object columnValue = resultSet.getObject(i + 1);
                    // String columnName = rsmd.getColumnName(i + 1);// 列名
                    String columnLabel = rsmd.getColumnLabel(i + 1);// 列名或别名

                    // 这里使用反射来给运行时的对象赋值
                    Field declaredField = clazz.getDeclaredField(columnLabel);
                    declaredField.setAccessible(true);
                    declaredField.set(obj, columnValue);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();

                if (ps != null)
                    ps.close();

                if (connect != null)
                    connect.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return obj;
    }

    /**
     * @插入
     */
    @Test
    public void test_insert() {
        try {
            insertSQL(777, "张老头", 65, 7556);
            System.out.println("插入成功！");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public void insertSQL(int id, String name, int age, int location_id) throws SQLException {
        Connection connect = getConnect();

        //预编译sql语句
        String sql = "INSERT INTO user VALUES(?, ?, ?, ?)";
        PreparedStatement ps = connect.prepareStatement(sql);

        // 填充占位符
        ps.setObject(1, id);
        ps.setObject(2, name);
        ps.setObject(3, age);
        ps.setObject(4, location_id);

        ps.execute();

        ps.close();
        connect.close();
    }
}
