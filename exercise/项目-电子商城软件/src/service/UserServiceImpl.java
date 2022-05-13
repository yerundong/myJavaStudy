package service;

import dao.User.UserDaoImpl;
import pojo.User;
import utils.jdbcUtils;

import java.sql.Connection;

public class UserServiceImpl implements UserService {
    private UserDaoImpl userDaoImpl = new UserDaoImpl();
    private Connection connection;
    {
        try {
            connection = jdbcUtils.getConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Boolean resister(User user) {
        int i = userDaoImpl.insertUser(connection, user);
        if(i == 1){
            return true;
        }
        return false;
    }

    @Override
    public User login(User user) {
        return userDaoImpl.getUserByNameAndPsw(connection, user.getName(), user.getPassword());
    }

    @Override
    public Boolean existUserName(String name) {
        User user = userDaoImpl.getUserByName(connection, name);
        return user == null ? false : true;
    }
}
