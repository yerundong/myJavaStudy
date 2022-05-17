package utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @Description jdbc通用方法封装（只含连接池获取连接的方法，其他查询、更新、关闭等方法使用Apache Commons DBUtils工具类里的）
 */
public class JdbcUtils {
    // 读取 druid.properties属性配置文件
    private static final Properties properties = new Properties();
    private static final InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties");

    // 连接池
    private static DataSource dataSource = null;

    static {
        try {
            // 从流中加载数据
            properties.load(inputStream);
            // 创建 数据库连接 池
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description 获取连接
     */
    public static Connection getConnect() throws Exception {
        return dataSource.getConnection();
    }
}
