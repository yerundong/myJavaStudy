package JDBC.事务;

import JDBC.lib.JDBCUtil;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class 无事务会出现的问题模拟 {


    /**
     * @无事务可能会出现的情况
     * @实现：id1给id2转账100写法，id1钱减少了，但id2钱未转入
     */
    @Test
    public void test1() {
        Connection connect = null;
        PreparedStatement ps = null;
        try {
            connect = JDBCUtil.getConnect();
            String sql = "UPDATE `jdbc_trans` SET `balance` = ? WHERE `id` = ?";
            ps = connect.prepareStatement(sql);

            JDBCUtil.setPrepareStatement(ps, 900, 1);
            ps.executeUpdate();

            System.out.println(10 / 0);// 模拟异常

            JDBCUtil.setPrepareStatement(ps, 1100, 2);
            ps.executeUpdate();

            System.out.println("更新成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }

        JDBCUtil.close(connect);
        JDBCUtil.close(ps);
    }

    /**
     * @引入事务解决以上问题
     */
    @Test
    public void test2() {
        Connection connect = null;
        PreparedStatement ps = null;
        try {
            connect = JDBCUtil.getConnect();
            String sql = "UPDATE `jdbc_trans` SET `balance` = ? WHERE `id` = ?";
            ps = connect.prepareStatement(sql);

            // 取消事务自动提交
            // System.out.println(connect.getAutoCommit());
            connect.setAutoCommit(false);

            JDBCUtil.setPrepareStatement(ps, 900, 1);
            ps.executeUpdate();

            // System.out.println(10 / 0);// 模拟异常

            JDBCUtil.setPrepareStatement(ps, 1100, 2);
            ps.executeUpdate();

            // 若没有异常，则提交事务
            connect.commit();

            System.out.println("更新成功！");
        } catch (Exception e) {
            e.printStackTrace();

            // 若有异常，则回滚
            try {
                connect.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } finally {
            try {
                // 恢复事务自动提交
                connect.setAutoCommit(true);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            JDBCUtil.close(connect);
            JDBCUtil.close(ps);
        }
    }
}
