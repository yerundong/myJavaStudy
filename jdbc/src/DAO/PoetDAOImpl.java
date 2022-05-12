package DAO;

import lib.Poet;

import java.sql.Array;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
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
        return update(cnn, sql, args);
    }

    /**
     * @插入多条Poet对象
     */
    @Override
    public int insert(Connection cnn, Poet[] poets) {
        String sql = "INSERT INTO `jdbc_poet` VALUES(?, ?, ?)";
        Object[][] objects = new Object[poets.length][3];
        for (int i = 0; i < poets.length; i++) {
            objects[i] = new Object[]{poets[i].getId(), poets[i].getName(), poets[i].getBirthDay()};
        }
        System.out.println(Arrays.deepToString(objects));
        return batchUpdate(cnn, sql, objects);
    }

    /**
     * @根据id删除一条记录
     */
    @Override
    public int deleteById(Connection cnn, int id) {
        String sql = "DELETE FROM `jdbc_poet` WHERE `id` = ?";
        return update(cnn, sql, id);
    }

    /**
     * @根据id删除多条记录
     */
    @Override
    public int deleteById(Connection cnn, int[] ids) {
        String sql = "DELETE FROM `jdbc_poet` WHERE `id` = ?";
        Object[][] objects = new Object[ids.length][1];
        for (int i = 0; i < ids.length; i++) {
            objects[i] = new Object[]{ids[i]};
        }
        return batchUpdate(cnn, sql, objects);
    }

    /**
     * @更新一条记录
     */
    @Override
    public int update(Connection cnn, Poet poet) {
        String sql = "UPDATE `jdbc_poet` SET `name` = ?, `birthDay` = ? WHERE `id` = ?";
        return update(cnn, sql, poet.getName(), poet.getBirthDay(), poet.getId());
    }

    /**
     * @更新多条记录
     */
    @Override
    public int update(Connection cnn, Poet[] poets) {
        String sql = "UPDATE `jdbc_poet` SET `name` = ?, `birthDay` = ? WHERE `id` = ?";
        Object[][] objects = new Object[poets.length][3];
        for (int i = 0; i < poets.length; i++) {
            objects[i] = new Object[]{poets[i].getName(), poets[i].getBirthDay(), poets[i].getId()};
        }
        return batchUpdate(cnn, sql, objects);
    }

    /**
     * @根据id获取Poet对象
     */
    @Override
    public Poet getPoetById(Connection cnn, int id) {
        String sql = "SELECT * FROM `jdbc_poet` WHERE `id` = ?";
        Poet poet = query(cnn, sql, id);
        return poet;
    }
}
