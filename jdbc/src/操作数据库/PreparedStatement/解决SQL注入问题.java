package 操作数据库.PreparedStatement;

import lib.JdbcUtilsComplete;
import lib.LoginInfo;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Scanner;

/**
 * sql注入模拟，输入：
 * 用户名：a' or
 * 密码：=1 or '1' = '1
 */
public class 解决SQL注入问题 {


    @Test
    public void testLogin() {
        Scanner scan = new Scanner(System.in);

        System.out.print("用户名：");
        String userName = scan.nextLine();
        System.out.println(userName);
        System.out.print("密   码：");
        String password = scan.nextLine();
        System.out.println(password);

        String sql = "SELECT `id`, `user` AS `name`, `age`, `birthday`, `password` FROM `jdbc_login` WHERE `user` = ? AND `password` = ?";
        List<LoginInfo> res = JdbcUtilsComplete.onceQuery(LoginInfo.class, sql, userName, password);
        System.out.println(res);


        if (res.size() > 0) {
            System.out.println("登陆成功!");
        } else {
            System.out.println("用户名或密码错误！");
        }
    }
}
