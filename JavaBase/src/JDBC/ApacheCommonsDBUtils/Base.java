package JDBC.ApacheCommonsDBUtils;

import JDBC.lib.JDBCUtil;
import JDBC.lib.Poet;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class Base {

    @Test
    public void test_insert() {
        Connection poolConnect = null;
        int count = 0;
        try {
            poolConnect = JDBCUtil.getPoolConnect();
            QueryRunner queryRunner = new QueryRunner();
            String sql = "INSERT INTO `jdbc_poet` VALUES (?, ?, ?)";
            count = queryRunner.update(poolConnect, sql, 4, "陆游", new Date(-52332234136L));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DbUtils.closeQuietly(poolConnect);
            System.out.println("已新增" + count + "条数据");
        }
    }

    @Test
    public void test_batch_insert() {
        Connection poolConnect = null;
        int count = 0;
        try {
            poolConnect = JDBCUtil.getPoolConnect();
            QueryRunner queryRunner = new QueryRunner();
            String sql = "INSERT INTO `jdbc_poet` VALUES (?, ?, ?)";
            Object[][] objects = {{4, "陆游", new Date(132234136L)}, {5, "李贺", new Date(-52332234136L)}};
            int[] batch = queryRunner.batch(poolConnect, sql, objects);
            for (int i : batch) {
                count += i;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DbUtils.closeQuietly(poolConnect);
            System.out.println("已新增" + count + "条数据");
        }
    }

    @Test
    public void test_delete() {
        Connection poolConnect = null;
        int count = 0;
        try {
            poolConnect = JDBCUtil.getPoolConnect();
            QueryRunner queryRunner = new QueryRunner();
            String sql = "DELETE FROM `jdbc_poet` WHERE `id` = ?";
            count = queryRunner.update(poolConnect, sql, 4);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DbUtils.closeQuietly(poolConnect);
            System.out.println("已删除" + count + "条数据");
        }
    }

    @Test
    public void test_batch_delete() {
        Connection poolConnect = null;
        int count = 0;
        try {
            poolConnect = JDBCUtil.getPoolConnect();
            QueryRunner queryRunner = new QueryRunner();
            String sql = "DELETE FROM `jdbc_poet` WHERE `id` = ?";
            int[] batch = queryRunner.batch(poolConnect, sql, new Object[][]{{4}, {5}});
            for (int i : batch) {
                count += i;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DbUtils.closeQuietly(poolConnect);
            System.out.println("已删除" + count + "条数据");
        }
    }

    @Test
    public void test_update() {
        Connection poolConnect = null;
        int count = 0;
        try {
            poolConnect = JDBCUtil.getPoolConnect();
            QueryRunner queryRunner = new QueryRunner();
            String sql = "UPDATE `jdbc_poet` SET `name` = ? WHERE `id` = ?";
            count = queryRunner.update(poolConnect, sql, "白居易", 3);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DbUtils.closeQuietly(poolConnect);
            System.out.println("已修改" + count + "条数据");
        }
    }

    @Test
    public void test_batch_update() {
        Connection poolConnect = null;
        int count = 0;
        try {
            poolConnect = JDBCUtil.getPoolConnect();
            QueryRunner queryRunner = new QueryRunner();
            String sql = "UPDATE `jdbc_poet` SET `name` = ? WHERE `id` = ?";
            int[] batch = queryRunner.batch(poolConnect, sql, new Object[][]{{"杜甫", 2}, {"白居易", 3}});
            for (int i : batch) {
                count += i;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DbUtils.closeQuietly(poolConnect);
            System.out.println("已修改" + count + "条数据");
        }
    }

    @Test
    public void test_query() {
        Connection poolConnect = null;
        Poet query = null;
        try {
            poolConnect = JDBCUtil.getPoolConnect();
            QueryRunner queryRunner = new QueryRunner();
            String sql = "SELECT * FROM `jdbc_poet` WHERE `id` = ?";
            BeanHandler<Poet> poetBeanHandler = new BeanHandler<>(Poet.class);
            query = queryRunner.query(poolConnect, sql, poetBeanHandler, 3);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DbUtils.closeQuietly(poolConnect);
            System.out.println(query);
        }
    }

    @Test
    public void test_batch_query() {
        Connection poolConnect = null;
        List<Poet> query = null;
        try {
            poolConnect = JDBCUtil.getPoolConnect();
            QueryRunner queryRunner = new QueryRunner();
            String sql = "SELECT * FROM `jdbc_poet` WHERE `id` > ?";
            BeanListHandler<Poet> poetBeanListHandler = new BeanListHandler<>(Poet.class);
            query = queryRunner.query(poolConnect, sql, poetBeanListHandler, 1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DbUtils.closeQuietly(poolConnect);
            System.out.println(query);
        }
    }
}
