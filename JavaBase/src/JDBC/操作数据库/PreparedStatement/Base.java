package JDBC.操作数据库.PreparedStatement;

import JDBC.lib.JDBCUtil;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.sql.*;

public class Base {
    // jdbc配置
    private final File JDBC_CONFIG = new File("JavaBase/src/JDBC/lib/jdbc.properties");
    private JDBCUtil jdbcUtil = new JDBCUtil(JDBC_CONFIG);

    /**
     * @预编译sql语句，并且获取PreparedStatement实例
     */
    @Test
    public void test1() {
        Connection connect = jdbcUtil.getConnect();
        String sql = "SELECT * FROM `login_info` WHERE `id` = 4";
        PreparedStatement ps = null;
        try {
            ps = connect.prepareStatement(sql);
            System.out.println(ps);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            if (ps != null) {
                ps.close();
            }
            if (ps != null) {
                connect.close();
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
        Connection connect = jdbcUtil.getConnect();
        String sql = "SELECT * FROM `login_info` WHERE `id` = ? OR `age` = ?";
        PreparedStatement ps = null;
        try {
            ps = connect.prepareStatement(sql);
            ps.setObject(1, 4);
            ps.setInt(1, 33);
            System.out.println(ps);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            if (ps != null) {
                ps.close();
            }
            if (ps != null) {
                connect.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * @获取结果集-next()
     */
    @Test
    public void test3() {
        Connection connect = jdbcUtil.getConnect();
        String sql = "SELECT * FROM `login_info` WHERE `id` = ?";
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = connect.prepareStatement(sql);
            ps.setObject(1, 4);

            resultSet = ps.executeQuery();
            System.out.println(resultSet);
            // System.out.println(resultSet.next());
            // System.out.println(resultSet.next());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            if (ps != null) {
                ps.close();
            }
            if (ps != null) {
                connect.close();
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
        Connection connect = jdbcUtil.getConnect();
        String sql = "SELECT * FROM `login_info` WHERE `id` = ?";
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = connect.prepareStatement(sql);
            ps.setObject(1, 4);

            resultSet = ps.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                String user = resultSet.getString(2);
                String psw = resultSet.getString(3);
                int age = resultSet.getInt(4);
                Date birth = resultSet.getDate(5);
                System.out.println(id);
                System.out.println(user);
                System.out.println(psw);
                System.out.println(age);
                System.out.println(birth);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            if (ps != null) {
                ps.close();
            }
            if (ps != null) {
                connect.close();
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
        Connection connect = jdbcUtil.getConnect();
        String sql = "SELECT * FROM `login_info`";
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
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

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            if (ps != null) {
                ps.close();
            }
            if (ps != null) {
                connect.close();
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
        Connection connect = jdbcUtil.getConnect();
        String sql = "SELECT `user` AS `usr` FROM `login_info`";
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = connect.prepareStatement(sql);
            resultSet = ps.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();// 元数据
            System.out.println(metaData);

            System.out.println(metaData.getColumnCount());// 总列数
            System.out.println(metaData.getTableName(1));// 表名
            System.out.println(metaData.getColumnName(1));// 字段名
            System.out.println(metaData.getColumnLabel(1));// 别名，没有别名就是字段名

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            if (ps != null) {
                ps.close();
            }
            if (ps != null) {
                connect.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
