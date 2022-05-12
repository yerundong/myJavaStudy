package 操作数据库.PreparedStatement;

import lib.jdbcUtilsComplete;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class Base {


    /**
     * @预编译sql语句，并且获取PreparedStatement实例
     */
    @Test
    public void test1() {
        Connection connect = null;
        String sql = "SELECT * FROM `jdbc_login` WHERE `id` = 4";
        PreparedStatement ps = null;
        try {
            connect = jdbcUtilsComplete.getConnect();
            ps = connect.prepareStatement(sql);
            System.out.println(ps);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }

        try {
            if (connect != null) {
                connect.close();
            }
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * @填充占位符
     */
    @Test
    public void test2() {
        Connection connect = null;
        String sql = "SELECT * FROM `jdbc_login` WHERE `id` = ? OR `age` = ?";
        PreparedStatement ps = null;
        try {
            connect = jdbcUtilsComplete.getConnect();
            ps = connect.prepareStatement(sql);
            ps.setObject(1, 4);
            ps.setInt(1, 33);
            System.out.println(ps);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }

        try {
            if (connect != null) {
                connect.close();
            }
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * @执行1
     */
    @Test
    public void test_execute() {
        // <M> boolean execute()
        // <返> 返回不是表示是否执行成功，而是是否是查询操作，PreparedStatement建议使用executeQuery和executeUpdate
        Connection connect = null;
        String sql = "SELECT * FROM `jdbc_login` WHERE `id` > ?";
        PreparedStatement ps = null;
        try {
            connect = jdbcUtilsComplete.getConnect();
            ps = connect.prepareStatement(sql);
            ps.setObject(1, 222);
            boolean execute = ps.execute();
            System.out.println(execute);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }

        try {
            if (connect != null) {
                connect.close();
            }
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * @执行2
     */
    @Test
    public void test_executeQuery() {
        // <M> ResultSet executeQuery()
        // <返> 查询返回结果集对象，结果集对象可遍历记录
        Connection connect = null;
        String sql = "SELECT * FROM `jdbc_login` WHERE `id` > ?";
        PreparedStatement ps = null;
        try {
            connect = jdbcUtilsComplete.getConnect();
            ps = connect.prepareStatement(sql);
            ps.setObject(1, 222);
            ResultSet resultSet = ps.executeQuery();
            System.out.println(resultSet);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }

        try {
            if (connect != null) {
                connect.close();
            }
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * @执行3
     */
    @Test
    public void test_executeUpdate() {
        // <M> int executeUpdate()
        // <返> 返回影响记录条数，为0表示无影响，即未更新成功
        Connection connect = null;
        String sql = "INSERT INTO `jdbc_login` VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = null;
        try {
            connect = jdbcUtilsComplete.getConnect();
            ps = connect.prepareStatement(sql);
            ps.setObject(1, 9);
            ps.setObject(2, "王石");
            ps.setObject(3, "123456");
            ps.setObject(4, 45);
            ps.setObject(5, new Date(1638773434000L));
            int i = ps.executeUpdate();
            System.out.println(i);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }

        try {
            if (connect != null) {
                connect.close();
            }
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * @获取结果集-遍历
     */
    @Test
    public void test3() {
        // <M> boolean next()
        // <返> 是否有数据，执行一次游标往下移动，初始位置在-1
        Connection connect = null;
        String sql = "SELECT * FROM `jdbc_login` WHERE `id` = ?";
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            connect = jdbcUtilsComplete.getConnect();
            ps = connect.prepareStatement(sql);
            ps.setObject(1, 4);

            resultSet = ps.executeQuery();
            System.out.println(resultSet);
            System.out.println(resultSet.next());
            System.out.println(resultSet.next());
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }

        try {
            if (connect != null) {
                connect.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * @获取结果集-获取列值
     */
    @Test
    public void test4() {
        Connection connect = null;
        String sql = "SELECT * FROM `jdbc_login` WHERE `id` = ?";
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            connect = jdbcUtilsComplete.getConnect();
            ps = connect.prepareStatement(sql);
            ps.setObject(1, 4);

            resultSet = ps.executeQuery();

            if (resultSet.next()) {
                // 方式一：根据索引取
                // int id = resultSet.getInt(1);
                // String user = resultSet.getString(2);
                // String psw = resultSet.getString(3);
                // int age = resultSet.getInt(4);
                // Date birth = resultSet.getDate(5);

                // 方式一：根据列名（别名）取
                int id = resultSet.getInt("id");
                String user = resultSet.getString("user");
                String psw = resultSet.getString("password");
                int age = resultSet.getInt("age");
                Date birth = resultSet.getDate("birthday");
                System.out.println(id);
                System.out.println(user);
                System.out.println(psw);
                System.out.println(age);
                System.out.println(birth);
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }

        try {
            if (connect != null) {
                connect.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * @获取结果集-多行数据
     */
    @Test
    public void test5() {
        Connection connect = null;
        String sql = "SELECT * FROM `jdbc_login`";
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            connect = jdbcUtilsComplete.getConnect();
            ps = connect.prepareStatement(sql);
            resultSet = ps.executeQuery();
            while (true) {
                if (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String user = resultSet.getString(2);
                    String psw = resultSet.getString(3);
                    int age = resultSet.getInt(4);
                    Date birth = resultSet.getDate(5);
                    System.out.print("id = " + id + ",");
                    System.out.print("user = " + user + ",");
                    System.out.print("password = " + psw + ",");
                    System.out.print("age = " + age + ",");
                    System.out.print("birth = " + birth + "\n");
                } else {
                    break;
                }
            }

        } catch (Exception throwables) {
            throwables.printStackTrace();
        }

        try {
            if (connect != null) {
                connect.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * @获取元数据，从而获取结果集的其他详细信息（字段名、别名、列数等）
     */
    @Test
    public void test6() {
        Connection connect = null;
        String sql = "SELECT `user` AS `usr` FROM `jdbc_login`";
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            connect = jdbcUtilsComplete.getConnect();

            ps = connect.prepareStatement(sql);
            resultSet = ps.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();// 元数据
            System.out.println(metaData);

            System.out.println(metaData.getColumnCount());// 总列数
            System.out.println(metaData.getTableName(1));// 表名
            System.out.println(metaData.getColumnName(1));// 字段名
            System.out.println(metaData.getColumnLabel(1));// 别名，没有别名就是字段名

        } catch (Exception throwables) {
            throwables.printStackTrace();
        }

        try {
            if (connect != null) {
                connect.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
