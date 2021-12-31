package DAO;

import lib.JDBCUtil;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.util.List;

public abstract class BaseDAO<T> {

    Class<T> clazz;

    // 以反射获取Class<T>
    {
        Class<? extends BaseDAO> aClass = this.getClass();
        Type type = aClass.getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Type[] types = parameterizedType.getActualTypeArguments();
        clazz = (Class<T>) types[0];
    }

    /**
     * @更新
     */
    public int commonUpdate(Connection cnn, String sql, Object... args) {
        int count = JDBCUtil.update(cnn, sql, args);
        JDBCUtil.close(cnn);
        return count;
    }

    /**
     * @批量更新
     */
    public int commonBatchUpdate(Connection cnn, String sql, List<Object[]> ls) {
        int count = JDBCUtil.batchUpdate(cnn, sql, ls);
        JDBCUtil.close(cnn);
        return count;
    }

    /**
     * @查询
     */
    public List<T> commonQuery(Connection cnn, String sql, Object... args) {
        List<T> ls = JDBCUtil.query(cnn, clazz, sql, args);
        JDBCUtil.close(cnn);
        return ls;
    }
}
