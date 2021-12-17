package JDBC.练习;

import JDBC.lib.JDBCUtil;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class 控制台插入记录 {
    // jdbc配置
    private final File JDBC_CONFIG = new File("JavaBase/src/JDBC/lib/jdbc.properties");
    private JDBCUtil jdbcUtil = new JDBCUtil(JDBC_CONFIG);

    /**
     * @
     */
    @Test
    public void test() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请填写插入数据相关信息：");
        
        System.out.print("id：");
        int id = scanner.nextInt();

        System.out.print("用户名：");
        String name = scanner.next();

        System.out.print("密码：");
        String password = scanner.next();

        System.out.print("年龄：");
        int age = scanner.nextInt();

        System.out.print("生日：");
        String birthday = scanner.next();
        System.out.println();

        DateTimeFormatter dtft = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(birthday, dtft);
        long timestamp = localDate.atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli();
        Date birth = new Date(timestamp);

        String sql = "INSERT INTO `login_info` VALUES(?, ?, ?, ?, ?)";
        jdbcUtil.update(sql, id, name, password, age, birth);
        System.out.println("插入成功！");
    }
}
