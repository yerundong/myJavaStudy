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
    /**
     * @Description 获取连接
     */
    public static Connection getConnect(File jdbcConfig) throws Exception {
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
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    /**
     * @Description 设置PreparedStatement占位符
     */
    public static void setPrepareStatement(PreparedStatement ps, Object... args) throws SQLException {
        // 填充占位符
        for (int i = 0; i < args.length; i++) {
            ps.setObject(i + 1, args[i]);
        }
    }

    /**
     * @Description 将查询结果集生成对象返回
     */
    public static <T> ArrayList<T> getQueryObjects(Class<T> clazz, ResultSet rs, ResultSetMetaData metaData) throws Exception {
        ArrayList<T> al = new ArrayList<>();
        // 获取列数
        int columnCount = metaData.getColumnCount();// 从元数据中获取列数

        // 遍历结果集
        while (true) {
            if (rs.next()) {
                Constructor constructor = clazz.getConstructor();
                T obj = (T) constructor.newInstance();

                for (int i = 0; i < columnCount; i++) {
                    Object columnValue = rs.getObject(i + 1);// 获取值
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
        return al;
    }

    /**
     * @Description 关闭操作
     */
    public static void close(Connection conn) throws SQLException {
        if (conn != null)
            conn.close();
    }

    /**
     * @Description 关闭操作
     */
    public static void close(PreparedStatement ps) throws SQLException {
        if (ps != null)
            ps.close();
    }

    /**
     * @Description 关闭操作
     */
    public static void close(Statement st) throws SQLException {
        if (st != null)
            st.close();
    }

    /**
     * @Description 关闭操作
     */
    public static void close(ResultSet rs) throws SQLException {
        if (rs != null)
            rs.close();
    }


    /**
     * @Description 一次性更新操作(包含增删改)
     */
    public static int onceUpdate(File jdbcConfig, String sql, Object... args) {
        // 1、获取连接
        Connection connect = null;
        PreparedStatement ps = null;

        try {
            connect = getConnect(jdbcConfig);

            // 2、预编译sql语句，返回prepareStatement实例
            ps = connect.prepareStatement(sql);

            // 3、填充占位符
            setPrepareStatement(ps, args);

            // 4、执行
            return ps.executeUpdate();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            // 5、关闭
            try {
                close(connect);
                close(ps);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return 0;
    }


    /**
     * 一次性通用查询，使用ArrayList做容器
     */
    public static <T> ArrayList<T> onceQuery(File jdbcConfig, Class<T> clazz, String sql, Object... args) {
        Connection connect = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        ArrayList<T> al = null;

        try {
            // 1、获取连接
            connect = getConnect(jdbcConfig);

            // 2、预编译sql语句，返回prepareStatement实例
            ps = connect.prepareStatement(sql);

            // 3、填充占位符
            setPrepareStatement(ps, args);

            // 4、执行查询，获得结果集
            resultSet = ps.executeQuery();

            // 5、获取元数据，从而获取列数
            ResultSetMetaData metaData = ps.getMetaData();// 获取元数据

            al = getQueryObjects(clazz, resultSet, metaData);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // 关闭
        try {
            close(connect);
            close(resultSet);
            close(ps);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return al;
    }
}
