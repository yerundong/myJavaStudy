package 操作数据库.PreparedStatement;

import lib.jdbcUtilsComplete;
import lib.LoginInfo;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class 实现增删改查 {
    /**
     * @测试插入
     */
    @Test
    public void test_add() {
        String updateSql = "INSERT INTO `jdbc_login` VALUES (?, ?, ?, ?, ?)";
        commonUpdate(updateSql, 4, "王五", 132789, 66, new Date(1638773434000L));
        System.out.println("插入成功！");
    }

    /**
     * @测试更新
     */
    @Test
    public void test_update() {
        String updateSql = "UPDATE `jdbc_login` SET `password` = ?, `age` = ? WHERE `id` = ?";
        int res = commonUpdate(updateSql, "666666", 88, 4);
        if (res > 0) {
            System.out.println("更新成功！");
        } else {
            System.out.println("更新失败！");
        }
    }

    /**
     * @测试删除
     */
    @Test
    public void test_dalete() {
        String updateSql = "DELETE FROM `jdbc_login` WHERE  `id` = ?";
        int res = commonUpdate(updateSql, 4);
        if (res > 0) {
            System.out.println("删除成功！");
        } else {
            System.out.println("删除失败！");
        }
    }

    /**
     * @测试查询
     */
    @Test
    public void test_select() {
        String sql = "SELECT `id`, `user` AS `name`, `age`, `birthday`, `password` FROM `jdbc_login` WHERE `id` < ?";
        List<LoginInfo> res = commonQuery(LoginInfo.class, sql, 5);
        System.out.println(res);
    }

    /**
     * @Description 更新操作(包含增删改)
     */
    public int commonUpdate(String sql, Object... args) {
        Connection connect = null;
        PreparedStatement ps = null;

        try {
            // 1、获取连接
            connect = jdbcUtilsComplete.getConnect();

            // 2、预编译sql语句，返回prepareStatement实例
            ps = connect.prepareStatement(sql);

            // 3、填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            // 4、执行
            return ps.executeUpdate();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            // 5、关闭
            try {
                if (connect != null)
                    connect.close();

                if (ps != null)
                    ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return 0;
    }

    /**
     * 通用sql查询，使用ArrayList做容器
     */
    public <T> List<T> commonQuery(Class<T> clazz, String sql, Object... args) {
        Connection connect = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<T> ls = new ArrayList<>();

        try {
            // 1、获取连接
            connect = jdbcUtilsComplete.getConnect();
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

                    ls.add(obj);// 装入容器
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
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ls;
    }
}
