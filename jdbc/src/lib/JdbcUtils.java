package lib;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import javax.sql.DataSource;
import java.io.File;
import java.io.FileReader;
import java.sql.*;
import java.util.Properties;

/**
 * @Description jdbc通用方法封装（只含连接池获取连接的方法，其他查询、更新、关闭等操作数据库方法使用Apache Commons DBUtils工具类里的）
 */
public class JdbcUtils {

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
        return dataSource.getConnection();
    }
}
