package JDBC.数据库连接池;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.FileReader;
import java.sql.Connection;
import java.util.Properties;

public class Base {
    // dataSource避免加载多次，所以使用静态
    private static DataSource dataSource = null;

    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("JavaBase/src/JDBC/lib/druid.jdbc.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @使用druid连接池获取连接
     */
    @Test
    public void test() throws Exception {
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
