package dao.User;

import pojo.User;

import java.sql.Connection;
import java.util.List;

public interface UserDao {
    /**
     * 插入一条用户
     */
    int insertUser(Connection cnn, User user);

    /**
     * 插入多条用户
     */
    int insertUser(Connection cnn, User... users);

    /**
     * 根据id删除用户
     */
    int deleteUserById(Connection cnn, Integer id);

    /**
     * 根据ids删除用户
     */
    int deleteUserById(Connection cnn, Integer... ids);

    /**
     * 更新用户
     */
    int updateUser(Connection cnn, User user);

    /**
     * 更新多条用户
     */
    int updateUser(Connection cnn, User... users);

    /**
     * 根据id获取用户
     */
    User getUserById(Connection cnn, Integer id);

    /**
     * 根据ids获取用户
     */
    List<User> getUserById(Connection cnn, Integer... ids);

    /**
     * 根据name获取用户，精确查询
     */
    User getUserByName(Connection cnn, String Name);

    /**
     * 根据name和password获取用户，精确查询
     */
    User getUserByNameAndPsw(Connection cnn, String name, String password);
}
