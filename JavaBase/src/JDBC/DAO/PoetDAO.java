package JDBC.DAO;

import JDBC.lib.Poet;

import java.sql.Connection;

public interface PoetDAO {

    /**
     * @插入一条Poet对象
     */
    int insert(Connection cnn, Poet poet);

    /**
     * @插入多条Poet对象
     */
    int insert(Connection cnn, Poet[] poets);

    /**
     * @根据id删除一条记录
     */
    int deleteById(Connection cnn, int id);

    /**
     * @根据id删除多条记录
     */
    int deleteById(Connection cnn, int[] ids);

    /**
     * @更新一条记录
     */
    int update(Connection cnn, Poet poet);

    /**
     * @更新多条记录
     */
    int update(Connection cnn, Poet[] poets);

    /**
     * @根据一个id获取Poet对象
     */
    Poet getPoetById(Connection cnn, int id);
}
