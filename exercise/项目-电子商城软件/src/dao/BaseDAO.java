package dao;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
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
     * @更新（包括增、删、改操作）
     * @return 如果返回-1表示更新失败，其他表示更新成功影响的行数
     */
    public int update(Connection cnn, String sql, Object... args) {
        QueryRunner queryRunner = new QueryRunner();
        try {
            return queryRunner.update(cnn, sql, args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DbUtils.closeQuietly(cnn);
        }
        return -1;
    }

    /**
     * @批量更新
     */
    public int batchUpdate(Connection cnn, String sql, Object[][] args) {
        QueryRunner queryRunner = new QueryRunner();
        try {
            int[] batch = queryRunner.batch(cnn, sql, args);
            int count = 0;
            for (int i : batch) {
                count += i;
            }
            return count;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DbUtils.closeQuietly(cnn);
        }
        return -1;
    }

    /**
     * @查询
     */
    public T query(Connection cnn, String sql, Object... args) {
        QueryRunner queryRunner = new QueryRunner();
        BeanHandler<T> tBeanHandler = new BeanHandler<T>(clazz);
        try {
            return queryRunner.query(cnn, sql, tBeanHandler, args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DbUtils.closeQuietly(cnn);
        }
        return null;
    }

    /**
     * @批量查询
     */
    public List<T> batchQuery(Connection cnn, String sql, Object... args) {
        QueryRunner queryRunner = new QueryRunner();
        BeanListHandler<T> tBeanListHandler = new BeanListHandler<>(clazz);
        try {
            return queryRunner.query(cnn, sql, tBeanListHandler, args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DbUtils.closeQuietly(cnn);
        }
        return null;
    }
}
