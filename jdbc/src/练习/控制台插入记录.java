package 练习;

import lib.JdbcUtilsComplete;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class 控制台插入记录 {


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

        String sql = "INSERT INTO `jdbc_login` VALUES(?, ?, ?, ?, ?)";
        JdbcUtilsComplete.onceUpdate(sql, id, name, password, age, birth);
        System.out.println("插入成功！");
    }
}
