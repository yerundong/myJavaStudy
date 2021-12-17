package JDBC.操作数据库.PreparedStatement;

import JDBC.lib.JDBCUtil;
import JDBC.lib.LoginInfo;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

/**
 * sql注入模拟，输入：
 * 用户名：a' or
 * 密码：=1 or '1' = '1
 */
public class 解决了SQL注入问题 {
    // jdbc配置
    private final File JDBC_CONFIG = new File("JavaBase/src/JDBC/lib/jdbc.properties");
    private JDBCUtil jdbcUtil = new JDBCUtil(JDBC_CONFIG);

    @Test
    public void testLogin() {
        Scanner scan = new Scanner(System.in);

        System.out.print("用户名：");
        String userName = scan.nextLine();
        System.out.println(userName);
        System.out.print("密   码：");
        String password = scan.nextLine();
        System.out.println(password);

        String sql = "SELECT `id`, `user` AS `name`, `age`, `birthday`, `password` FROM `login_info` WHERE `user` = ? AND `password` = ?";
        LoginInfo res = commonQuery(LoginInfo.class, sql, userName, password);
        System.out.println(res);


        if (res != null) {
            System.out.println("登陆成功!");
        } else {
            System.out.println("用户名或密码错误！");
        }
    }

    /**
     * 通用sql查询，使用ArrayList做容器
     */
    public <T> T commonQuery(Class<T> clazz, String sql, Object... args) {
        // 1、获取连接
        Connection connect = jdbcUtil.getConnect();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        T obj = null;

        try {
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

            if (resultSet.next()) {
                Constructor constructor = clazz.getConstructor();
                obj = (T) constructor.newInstance();

                for (int i = 0; i < columnCount; i++) {
                    Object columnValue = resultSet.getObject(i + 1);// 获取值
                    String columnLabel = metaData.getColumnLabel(i + 1);// 获取列名(别名)

                    // 这里使用反射来给运行时的对象赋值
                    Field declaredField = clazz.getDeclaredField(columnLabel);
                    declaredField.setAccessible(true);
                    declaredField.set(obj, columnValue);
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
        } catch (Exception e) {
            e.printStackTrace();
        }

        return obj;
    }
}
