package JDBC.lib;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

/**
 * @Description jdbc通用方法封装，包括连接、查询、更新操作
 */
public class JDBCUtil {
    // jdbc配置
    private File jdbcConfig;

    public JDBCUtil(File jdbcConfig) {
        this.jdbcConfig = jdbcConfig;
    }

    /**
     * @Description 获取连接
     */
    public Connection getConnect() {
        Connection conn = null;
        try {
            // 1.取配置
            Properties properties = new Properties();
            FileReader fileReader = new FileReader(jdbcConfig);
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
     * @Description 更新操作(包含增删改)
     */
    public int update(String sql, Object... args) {
        // 1、获取连接
        Connection connect = getConnect();
        PreparedStatement ps = null;

        try {
            // 2、预编译sql语句，返回prepareStatement实例
            ps = connect.prepareStatement(sql);

            // 3、填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            // 4、执行
            return ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            // 5、关闭
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                connect.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return 0;
    }

    /**
     * 通用查询，使用ArrayList做容器
     */
    public <T> ArrayList<T> query(Class<T> clazz, String sql, Object... args) {
        // 1、获取连接
        Connection connect = getConnect();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        ArrayList<T> al = new ArrayList<>();

        try {
            // 2、预编译sql语句，返回prepareStatement实例
            ps = connect.prepareStatement(sql);

            // 3、填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            // 4、执行查询，获得结果集
            resultSet = ps.executeQuery();

            // 5、获取元数据，从而获取列数
            ResultSetMetaData metaData = ps.getMetaData();// 获取元数据
            int columnCount = metaData.getColumnCount();// 从元数据中获取列数

            // 遍历结果集
            while (true) {
                if (resultSet.next()) {
                    Constructor constructor = clazz.getConstructor();
                    T obj = (T) constructor.newInstance();

                    for (int i = 0; i < columnCount; i++) {
                        Object columnValue = resultSet.getObject(i + 1);// 获取值
                        String columnLabel = metaData.getColumnLabel(i + 1);// 获取列名(别名)

                        // 这里使用反射来给运行时的对象赋值
                        Field declaredField = clazz.getDeclaredField(columnLabel);
                        declaredField.setAccessible(true);
                        declaredField.set(obj, columnValue);
                    }

                    al.add(obj);// 装入容器
                } else {
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // 关闭
        try {
            if (connect != null)
                connect.close();

            if (resultSet != null)
                resultSet.close();

            if (ps != null)
                ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return al;
    }

    public File getJdbcConfig() {
        return jdbcConfig;
    }

    public void setJdbcConfig(File jdbcConfig) {
        this.jdbcConfig = jdbcConfig;
    }
}
