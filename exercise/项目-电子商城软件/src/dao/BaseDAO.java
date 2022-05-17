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
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }finally {
            DbUtils.closeQuietly(cnn);
        }
    }

    /**
     * @批量更新
     */
    public int batchUpdate(Connection cnn, String sql, Object[]... args) {
        QueryRunner queryRunner = new QueryRunner();
        try {
            int[] batch = queryRunner.batch(cnn, sql, args);
            int count = 0;
            for (int i : batch) {
                count += i;
            }
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }finally {
            DbUtils.closeQuietly(cnn);
        }
    }

    /**
     * @查询
     */
    public List<T> query(Connection cnn, String sql, Object... args) {
        QueryRunner queryRunner = new QueryRunner();
        BeanListHandler<T> beanListHandler = new BeanListHandler<>(clazz);
        try {
            return queryRunner.query(cnn, sql, beanListHandler, args);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            DbUtils.closeQuietly(cnn);
        }
    }

    /**
     * @查询单个
     */
    public T queryOne(Connection cnn, String sql, Object... args) {
        QueryRunner queryRunner = new QueryRunner();
        BeanHandler<T> beanHandler = new BeanHandler<T>(clazz);
        try {
            return queryRunner.query(cnn, sql, beanHandler, args);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            DbUtils.closeQuietly(cnn);
        }
    }
}
