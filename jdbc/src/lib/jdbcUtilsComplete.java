package lib;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @Description 完全自己写的jdbc通用方法封装（包含获取连接*2、更新、查询、关闭等操作）
 */
public class jdbcUtilsComplete {
    // jdbc配置
    private static final File JDBC_CONFIG = new File("src/jdbc.properties");
    // druid jdbc配置
    private static final File DRUID_CONFIG = new File("src/druid.properties");

    // 连接池
    private static DataSource dataSource = null;

    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(DRUID_CONFIG));
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description 获取连接
     */
    public static Connection getConnect() throws Exception {
        // 1.取配置
        Properties properties = new Properties();
        FileReader fileReader = new FileReader(JDBC_CONFIG);
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
     * @Description 使用druid连接池获取连接（推荐）
     */
    public static Connection getPoolConnect() throws SQLException {
        return dataSource.getConnection();
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
     * @Description 更新
     */
    public static int update(Connection connect, String sql, Object... args) {
        PreparedStatement ps = null;
        int count = 0;
        try {
            ps = connect.prepareStatement(sql);
            setPrepareStatement(ps, args);
            count = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close(ps);
            return count;
        }
    }

    /**
     * @Description 批量更新
     */
    public static int batchUpdate(Connection connect, String sql, List<Object[]> ls) {
        PreparedStatement ps = null;
        int count = 0;
        try {
            connect.setAutoCommit(false);
            ps = connect.prepareStatement(sql);
            int len = ls.size();// 更新数据总条数
            int cbuf = 2;// 缓冲小车

            for (int i = 0; i < len; i++) {
                Object[] args = ls.get(i);
                setPrepareStatement(ps, args);
                ps.addBatch();
                if ((i + 1) % cbuf == 0) {
                    int[] counts = ps.executeBatch();
                    for (int c : counts) {
                        count += c;
                    }
                    ps.clearBatch();
                }
            }

            // 若有剩余，最后执行一次
            if (len % cbuf != 0) {
                int[] ints = ps.executeBatch();
                ps.clearBatch();
            }

            connect.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connect.setAutoCommit(true);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            close(ps);
            return count;
        }
    }

    /**
     * @Description 将查询结果集生成对象返回
     */
    public static <T> List<T> getQueryObjects(Class<T> clazz, ResultSet rs, ResultSetMetaData metaData) throws Exception {
        List<T> ls = new ArrayList<>();
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

                ls.add(obj);// 装入容器
            } else {
                break;
            }
        }
        return ls;
    }

    /**
     * @查询
     */
    public static <T> List<T> query(Connection connect, Class<T> clazz, String sql, Object... args) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<T> ls = null;

        try {
            ps = connect.prepareStatement(sql);
            setPrepareStatement(ps, args);
            resultSet = ps.executeQuery();
            ResultSetMetaData metaData = ps.getMetaData();
            ls = getQueryObjects(clazz, resultSet, metaData);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            close(ps);
            close(resultSet);
            return ls == null ? new ArrayList<T>() : ls;
        }
    }

    /**
     * @Description 关闭操作
     */
    public static void close(Connection conn) {
        if (conn != null)
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
    }

    /**
     * @Description 关闭操作
     */
    public static void close(PreparedStatement ps) {
        if (ps != null)
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
    }

    /**
     * @Description 关闭操作
     */
    public static void close(Statement st) {
        if (st != null)
            try {
                st.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
    }

    /**
     * @Description 关闭操作
     */
    public static void close(ResultSet rs) {
        if (rs != null)
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
    }


    /**
     * 完整的更新操作(包含连接 、 更新 、 关闭操作)
     */
    public static int onceUpdate(String sql, Object... args) {
        Connection connect = null;
        int update = 0;

        try {
            connect = getConnect();
            update = update(connect, sql, args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(connect);
            return update;
        }
    }


    /**
     * 完整的查询操作(包含连接 、 查询 、 关闭操作)，使用ArrayList做容器
     */
    public static <T> List<T> onceQuery(Class<T> clazz, String sql, Object... args) {
        Connection connect = null;
        List<T> ls = null;

        try {
            connect = getConnect();
            ls = query(connect, clazz, sql, args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(connect);
            return ls == null ? new ArrayList<T>() : ls;
        }
    }
}
