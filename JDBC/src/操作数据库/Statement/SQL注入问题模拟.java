package 操作数据库.Statement;

import lib.JDBCUtil;
import lib.LoginInfo_statement;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;

/**
 * 具体用法与PreparedStatement基本一样，请参考PreparedStatement，这里演示Statement的弊端
 * sql注入模拟，输入：
 * 用户名：a' or
 * 密码：=1 or '1' = '1
 */
public class SQL注入问题模拟 {


    @Test
    public void testLogin() {
        Scanner scan = new Scanner(System.in);

        System.out.print("用户名：");
        String userName = scan.nextLine();
        System.out.println(userName);
        System.out.print("密   码：");
        String password = scan.nextLine();
        System.out.println(password);

        // 需要拼写sql语句
        String sql = "SELECT `user`, `password` FROM jdbc_login WHERE `user` = '" + userName + "' AND `password` = '" + password + "'";
        System.out.println("sql语句：" + sql);

        LoginInfo_statement obj = select(LoginInfo_statement.class, sql);

        if (obj != null) {
            System.out.println(obj);
            System.out.println("登陆成功!");
        } else {
            System.out.println("用户名或密码错误！");
        }
    }

    // 使用Statement实现对数据表的查询操作
    public <T> T select(Class<T> clazz, String sql) {
        T t = null;
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConnect();

            st = conn.createStatement();

            rs = st.executeQuery(sql);

            // 获取结果集的元数据
            ResultSetMetaData rsmd = rs.getMetaData();

            // 获取结果集的列数
            int columnCount = rsmd.getColumnCount();

            // 建对象，赋值
            // 这里多个结果集只取第一个建对象来返回
            if (rs.next()) {

                t = clazz.newInstance();

                for (int i = 0; i < columnCount; i++) {
                    // //1. 获取列的名称
                    // String columnName = rsmd.getColumnName(i+1);

                    // 1. 获取列的别名
                    String columnName = rsmd.getColumnLabel(i + 1);

                    // 2. 根据列名获取对应数据表中的数据
                    Object columnVal = rs.getObject(columnName);

                    // 3. 将数据表中得到的数据，封装进对象
                    Field field = clazz.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(t, columnVal);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            JDBCUtil.close(conn);
            JDBCUtil.close(rs);
            JDBCUtil.close(st);
        }

        return null;
    }
}