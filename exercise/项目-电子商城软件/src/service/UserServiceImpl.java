package service;

import dao.User.UserDaoImpl;
import pojo.User;
import utils.JdbcUtils;

import java.sql.Connection;

public class UserServiceImpl implements UserService {
    private UserDaoImpl userDaoImpl = new UserDaoImpl();

    @Override
    public Boolean register(User user) {
        Connection connection = null;
        try {
            connection = JdbcUtils.getConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        int i = userDaoImpl.insertUser(connection, user);
        if(i == 1){
            return true;
        }

        return false;
    }

    @Override
    public User login(User user) {
        Connection connection = null;
        try {
            connection = JdbcUtils.getConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userDaoImpl.getUserByNameAndPsw(connection, user.getName(), user.getPassword());
    }

    @Override
    public Boolean existUserName(String name) {
        Connection connection = null;
        try {
            connection = JdbcUtils.getConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        User user = userDaoImpl.getUserByName(connection, name);
        return user == null ? false : true;
    }
}
