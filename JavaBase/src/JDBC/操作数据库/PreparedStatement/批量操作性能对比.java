package JDBC.操作数据库.PreparedStatement;

import JDBC.lib.JDBCUtil;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class 批量操作性能对比 {
    // jdbc配置
    private final File JDBC_CONFIG = new File("JavaBase/src/JDBC/lib/jdbc.properties");

    /**
     * @PreparedStatement批量插入性能测试：1000000条-1.094s（最终版）
     */
    @Test
    public void test_PreparedStatement() {
        long start = System.currentTimeMillis();
        Connection connect = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO `jdbc_batch` VALUES (?, ?)";

        try {
            // 1、获取连接
            connect = JDBCUtil.getConnect(JDBC_CONFIG);

            // 2、预编译sql语句，返回prepareStatement实例
            ps = connect.prepareStatement(sql);

            // 关闭自动提交，提高性能
            connect.setAutoCommit(false);

            // 3、填充占位符
            int count = 1000000;
            int cbuf = 1000000;// 缓冲小车
            for (int i = 0; i < count; i++) {
                ps.setObject(1, null);
                ps.setObject(2, "name_" + (i + 1));

                //“攒”sql
                ps.addBatch();

                // 每满小车时执行一次
                if (i % cbuf == 0) {
                    //执行
                    ps.executeBatch();
                    //清空
                    ps.clearBatch();
                }
            }

            // 若有剩余，最后执行一次
            if (count % cbuf != 0) {
                //执行
                ps.executeBatch();
                //清空
                ps.clearBatch();
            }

            // 提交数据
            connect.commit();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            // 5、关闭
            try {
                JDBCUtil.close(connect);
                JDBCUtil.close(ps);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("花费时间：" + (end - start));
    }

    /**
     * @Statement批量插入性能测试：10000条-26.568s
     */
    @Test
    public void test_Statement() {
        long start = System.currentTimeMillis();
        Connection connect = null;
        Statement st = null;


        try {
            // 1、获取连接
            connect = JDBCUtil.getConnect(JDBC_CONFIG);

            // 2、预编译sql语句，返回prepareStatement实例
            st = connect.createStatement();
            // 3、填充占位符
            for (int i = 0; i < 10000; i++) {
                String sql = "INSERT INTO `jdbc_batch` VALUES (NULL, 'name_" + (i + 1) + "')";

                // 4、执行
                st.executeUpdate(sql);
            }

        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            // 5、关闭
            try {
                JDBCUtil.close(connect);
                JDBCUtil.close(st);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("花费时间：" + (end - start));
    }
}
