package service;

import org.junit.jupiter.api.Test;
import pojo.User;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {
    private UserServiceImpl userServiceImpl = new UserServiceImpl();

    @Test
    void resister() {
        User user = new User(0, 1, "哈破仁2", "hpr123@qq.com", null, "321654");
        System.out.println(userServiceImpl.resister(user));
    }

    @Test
    void login() {
        User user = new User(0, 0, "哈破仁", null, null, "321654");
        User login = userServiceImpl.login(user);
        System.out.println(login);
    }

    @Test
    void existUserName() {
        Boolean b = userServiceImpl.existUserName("哈破仁");
        System.out.println(b);
    }
}