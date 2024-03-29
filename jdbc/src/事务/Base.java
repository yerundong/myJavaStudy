package 事务;

import lib.JdbcUtilsComplete;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

public class Base {


    /**
     * @设置事务自动提交
     * @注：事务结束之后，一定要恢复自动提交
     */
    @Test
    public void test_AutoCommit() {
        Connection connect = null;

        try {
            connect = JdbcUtilsComplete.getConnect();

            // 取消事务自动提交
            // System.out.println(connect.getAutoCommit());
            connect.setAutoCommit(false);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 恢复事务自动提交
                connect.setAutoCommit(true);
                JdbcUtilsComplete.close(connect);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /**
     * @提交、回滚
     */
    @Test
    public void test_commit_rollback() {
        Connection connect = null;
        PreparedStatement ps = null;
        int count = 1;

        try {
            connect = JdbcUtilsComplete.getConnect();
            String sql = "INSERT INTO `jdbc_trans` VALUES(NULL, ?)";
            ps = connect.prepareStatement(sql);

            // 取消事务自动提交
            connect.setAutoCommit(false);

            // 非数据库操作，不受回滚影响
            count++;

            // 数据库操作，受回滚影响
            JdbcUtilsComplete.setPrepareStatement(ps, 2500);
            ps.executeUpdate();

            System.out.println(10 / 0);// 模拟异常

            // 若没有异常，则提交事务
            connect.commit();

        } catch (Exception e) {
            e.printStackTrace();

            // 若有异常，则回滚，回滚本事务里的全部数据库操作
            try {
                connect.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } finally {
            System.out.println(count);
            try {
                // 恢复事务自动提交
                connect.setAutoCommit(true);
                JdbcUtilsComplete.close(connect);
                JdbcUtilsComplete.close(ps);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /**
     * @回滚断点
     */
    @Test
    public void test_Savepoint() {
        Connection connect = null;
        PreparedStatement ps = null;
        Savepoint point = null;

        try {
            connect = JdbcUtilsComplete.getConnect();
            String sql = "INSERT INTO `jdbc_trans` VALUES(NULL, ?)";
            ps = connect.prepareStatement(sql);

            // 取消事务自动提交
            connect.setAutoCommit(false);

            // 数据库操作，不受回滚影响
            JdbcUtilsComplete.setPrepareStatement(ps, 55);
            ps.executeUpdate();

            // 设置断点
            point = connect.setSavepoint();

            // 数据库操作，受回滚影响
            JdbcUtilsComplete.setPrepareStatement(ps, 66);
            ps.executeUpdate();

            System.out.println(10 / 0);// 模拟异常

            // 若没有异常，则提交事务
            connect.commit();

        } catch (Exception e) {
            e.printStackTrace();

            // 若有异常，则回滚到断点
            try {
                connect.rollback(point);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } finally {
            try {
                // 恢复事务自动提交
                connect.setAutoCommit(true);
                JdbcUtilsComplete.close(connect);
                JdbcUtilsComplete.close(ps);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /**
     * @获取、设置事务隔离级别
     * @注：每次新的连接、数据库服务重启会恢复到默认隔离级别
     */
    @Test
    public void test_isolation() {
        Connection connect = null;
        PreparedStatement ps = null;

        try {
            connect = JdbcUtilsComplete.getConnect();
            int isolation = connect.getTransactionIsolation();
            System.out.println(isolation);

            connect.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            System.out.println(connect.getTransactionIsolation());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtilsComplete.close(connect);
        }
    }
}
