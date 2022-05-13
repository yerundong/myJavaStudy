package dao.User;

import dao.BaseDAO;
import pojo.User;

import java.sql.Connection;
import java.util.List;

public class UserDaoImpl extends BaseDAO<User> implements UserDao {
    @Override
    public int insertUser(Connection cnn, User user) {
        String sql = "INSERT INTO `user` VALUES(?, ?, ?, ?, ?, ?)";
        return update(cnn, sql, user.getId(), user.getName(), user.getNickName(), user.getEmail(), user.getPassword(), user.getGender());
    }

    @Override
    public int insertUser(Connection cnn, User... users) {
        String sql = "INSERT INTO `user` VALUES(?, ?, ?, ?, ?, ?)";
        Object[][] users_ = new Object[users.length][6];
        for (int i = 0; i < users.length; i++) {
            User user = users[i];
            users_[i] = new Object[]{user.getId(), user.getName(), user.getNickName(), user.getEmail(), user.getPassword(), user.getGender()};
        }
        return batchUpdate(cnn, sql, users_);
    }

    @Override
    public int deleteUserById(Connection cnn, Integer id) {
        String sql = "DELETE FROM `user` WHERE `id` = ?";
        return update(cnn, sql, id);
    }

    @Override
    public int deleteUserById(Connection cnn, Integer... ids) {
        String sql = "DELETE FROM `user` WHERE `id` = ?";
        Object[][] ids_ = new Object[ids.length][1];
        for (int i = 0; i < ids.length; i++) {
            ids_[i] = new Object[]{ids[i]};
        }
        return batchUpdate(cnn, sql, ids_);
    }

    @Override
    public int updateUser(Connection cnn, User user) {
        String sql = "UPDATE `user` SET `name` = ?, `nickName` = ?, `email` = ?, `password` = ?, `gender` = ? WHERE `id` = ?";
        return update(cnn, sql, user.getName(), user.getNickName(), user.getEmail(), user.getPassword(), user.getGender(), user.getId());
    }

    @Override
    public int updateUser(Connection cnn, User... users) {
        String sql = "UPDATE `user` SET `name` = ?, `nickName` = ?, `email` = ?, `password` = ?, `gender` = ? WHERE `id` = ?";
        Object[][] users_ = new Object[users.length][6];
        for (int i = 0; i < users.length; i++) {
            User user = users[i];
            users_[i] = new Object[]{user.getName(), user.getNickName(), user.getEmail(), user.getPassword(), user.getGender(), user.getId()};
        }
        return batchUpdate(cnn, sql, users_);
    }

    @Override
    public User getUserById(Connection cnn, Integer id) {
        String sql = "SELECT * FROM `user` WHERE `id` = ?";
        return queryOne(cnn, sql, id);
    }

    @Override
    public List<User> getUserById(Connection cnn, Integer... ids) {
        StringBuilder idsStr = new StringBuilder();
        for (int i = 0; i < ids.length; i++) {
            idsStr.append("?,");
        }
        idsStr = new StringBuilder(idsStr.substring(0, idsStr.length()-1));
        String sql = "SELECT * FROM `user` WHERE `id` IN (" + idsStr +")";
        return query(cnn, sql, ids);
    }

    @Override
    public User getUserByName(Connection cnn, String name) {
        String sql = "SELECT * FROM `user` WHERE `name` = ?";
        return queryOne(cnn, sql, name);
    }

    @Override
    public User getUserByNameAndPsw(Connection cnn, String name, String password) {
        String sql = "SELECT * FROM `user` WHERE `name` = ? AND `password` = ?";
        return queryOne(cnn, sql, name, password);
    }
}
