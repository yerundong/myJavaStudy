package dao.User;

import org.junit.jupiter.api.Test;
import pojo.User;
import utils.JdbcUtils;

import java.io.File;
import java.sql.Connection;
import java.util.List;

class UserDaoImplTest {
    private UserDaoImpl userDao = new UserDaoImpl();
    private Connection connect = null;
    {
        try {
            connect = JdbcUtils.getConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void insertUser() {
        User user = new User(10001, 1, "胡建仁", "hjr123@168.com", "me hjr", "123456");
        int i = userDao.insertUser(connect, user);
        System.out.println(i);
    }

    @Test
    void testInsertUser() {
        User user1 = new User(10002, 1, "胡建仁2", "hjr123@168.com", "me hjr", "123456");
        User user2 = new User(10003, 1, "胡建仁3", "hjr123@168.com", "me hjr", "123456");
        int i = userDao.insertUser(connect, user1, user2);
        System.out.println(i);
    }

    @Test
    void deleteUserById() {
        int i = userDao.deleteUserById(connect, 10001);
        System.out.println(i);
    }

    @Test
    void testDeleteUserById() {
        int i = userDao.deleteUserById(connect,  10001,10002, 10003);
        System.out.println(i);
    }

    @Test
    void updateUser() {
        User user = new User(10002, 1, "胡洲仁", "hzr123@168.com", "me hzr", "123456");
        int i = userDao.updateUser(connect,user );
        System.out.println(i);
    }

    @Test
    void testUpdateUser() {
        User user1 = new User(10002, 1, "胡洲仁", "hzr123@168.com", "me hzr", "123456");
        User user2 = new User(10003, 1, "胡安仁", "har123@168.com", "me har", "123456");
        int i = userDao.updateUser(connect,user1, user2 );
        System.out.println(i);
    }

    @Test
    void getUserById() {
        User i = userDao.getUserById(connect, 10001);
        System.out.println(i);
    }

    @Test
    void testGetUserById() {
        List<User> i = userDao.getUserById(connect, 10002, 10003);
        System.out.println(i);
    }

    @Test
    void getUserByName() {
        User i = userDao.getUserByName(connect, "胡建仁");
        System.out.println(i);
    }

    @Test
    void getUserByNameAndPsw() {
        User i = userDao.getUserByNameAndPsw(connect, "胡建仁", "123456");
        System.out.println(i);
    }
}