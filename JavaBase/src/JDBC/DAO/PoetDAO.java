package JDBC.DAO;

import JDBC.lib.Poet;

import java.sql.Connection;
import java.util.List;

public interface PoetDAO {

    /**
     * @return boolean
     * @Description 插入一条Poet对象
     * @Param [cnn, poet]
     * @Author 叶润东
     * @Date 14:40 2021/12/22
     */
    boolean insert(Connection cnn, Poet poet);

    /**
     * @return boolean
     * @Description 插入多条Poet对象
     * @Param [cnn, poet]
     * @Author 叶润东
     * @Date 14:40 2021/12/22
     */
    boolean insert(Connection cnn, Poet[] poets);

    /**
     * @return boolean
     * @Description 根据id删除一条记录
     * @Param [cnn, id]
     * @Author 叶润东
     * @Date 14:42 2021/12/22
     */
    boolean deleteById(Connection cnn, int id);

    /**
     * @return boolean
     * @Description 根据id删除多条记录
     * @Param [cnn, id]
     * @Author 叶润东
     * @Date 14:42 2021/12/22
     */
    boolean deleteById(Connection cnn, int[] ids);

    /**
     * @return boolean
     * @Description 更新一条记录
     * @Param [cnn, poet]
     * @Author 叶润东
     * @Date 14:46 2021/12/22
     */
    boolean update(Connection cnn, Poet poet);

    /**
     * @return boolean
     * @Description 更新多条记录
     * @Param [cnn, poet]
     * @Author 叶润东
     * @Date 14:46 2021/12/22
     */
    boolean update(Connection cnn, Poet[] poets);

    /**
     * @return JDBC.lib.Poet
     * @Description 根据id获取Poet对象
     * @Param [cnn]
     * @Author 叶润东
     * @Date 14:37 2021/12/22
     */
    Poet getPoetById(Connection cnn, int id);

    /**
     * @return java.util.List<JDBC.lib.Poet>
     * @Description 获取所有Poet对象
     * @Param [cnn]
     * @Author 叶润东
     * @Date 14:39 2021/12/22
     */
    List<Poet> getPoets(Connection cnn);
}
