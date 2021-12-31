package DAO;

import lib.Poet;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class PoetDAOImpl extends BaseDAO<Poet> implements PoetDAO {

    /**
     * @插入一条Poet对象
     */
    @Override
    public int insert(Connection cnn, Poet poet) {
        String sql = "INSERT INTO `jdbc_poet` VALUES(?, ?, ?)";
        Object[] args = {
                poet.getId(), poet.getName(), poet.getBirthDay()
        };
        return commonUpdate(cnn, sql, args);
    }

    /**
     * @插入多条Poet对象
     */
    @Override
    public int insert(Connection cnn, Poet[] poets) {
        String sql = "INSERT INTO `jdbc_poet` VALUES(?, ?, ?)";
        List ls = new ArrayList<>();
        for (Poet poet : poets) {
            Object[] args = {
                    poet.getId(), poet.getName(), poet.getBirthDay()
            };
            ls.add(args);
        }
        return commonBatchUpdate(cnn, sql, ls);
    }

    /**
     * @根据id删除一条记录
     */
    @Override
    public int deleteById(Connection cnn, int id) {
        String sql = "DELETE FROM `jdbc_poet` WHERE `id` = ?";
        return commonUpdate(cnn, sql, id);
    }

    /**
     * @根据id删除多条记录
     */
    @Override
    public int deleteById(Connection cnn, int[] ids) {
        String sql = "DELETE FROM `jdbc_poet` WHERE `id` = ?";
        List ls = new ArrayList<>();
        for (int id : ids) {
            Object[] args = {id};
            ls.add(args);
        }
        return commonBatchUpdate(cnn, sql, ls);
    }

    /**
     * @更新一条记录
     */
    @Override
    public int update(Connection cnn, Poet poet) {
        String sql = "UPDATE `jdbc_poet` SET `name` = ?, `birthDay` = ? WHERE `id` = ?";
        return commonUpdate(cnn, sql, poet.getName(), poet.getBirthDay(), poet.getId());
    }

    /**
     * @更新多条记录
     */
    @Override
    public int update(Connection cnn, Poet[] poets) {
        String sql = "UPDATE `jdbc_poet` SET `name` = ?, `birthDay` = ? WHERE `id` = ?";
        List ls = new ArrayList<>();
        for (Poet poet : poets) {
            Object[] args = {poet.getName(), poet.getBirthDay(), poet.getId()};
            ls.add(args);
        }
        return commonBatchUpdate(cnn, sql, ls);
    }

    /**
     * @根据id获取Poet对象
     */
    @Override
    public Poet getPoetById(Connection cnn, int id) {
        String sql = "SELECT * FROM `jdbc_poet` WHERE `id` = ?";
        List<Poet> poets = commonQuery(cnn, sql, id);
        if (poets.size() > 0) {
            return poets.get(0);
        } else {
            return null;
        }
    }
}
