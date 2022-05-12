package utils;

import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class jdbcUtilsTest {

    @Test
    void getConnect() throws Exception {
        Connection connect = jdbcUtils.getConnect();
        System.out.println(connect);
    }
}