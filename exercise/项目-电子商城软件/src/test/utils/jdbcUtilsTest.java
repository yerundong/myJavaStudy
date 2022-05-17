package utils;

import org.junit.jupiter.api.Test;

import java.sql.Connection;

class jdbcUtilsTest {

    @Test
    void getConnect() throws Exception {
        Connection connect = JdbcUtils.getConnect();
        System.out.println(connect);
    }
}