package service;

import pojo.User;

public interface UserService {

    /**
     * 注册
     */
    Boolean resister(User user);

    /**
     * 登录
     */
    User login(User user);

    /**
     * 用户名是否存在
     */
    Boolean existUserName(String name);
}
