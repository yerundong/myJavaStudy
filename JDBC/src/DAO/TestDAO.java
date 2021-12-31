package DAO;

import lib.JDBCUtil;
import lib.Poet;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.Date;

public class TestDAO {
    public PoetDAOImpl poetDAO = new PoetDAOImpl();

    @Test
    public void testInsert() {
        int insert = 0;
        Connection connect = null;
        try {
            Poet lb = new Poet(1, "李白", new Date(-31245257943000L));
            connect = JDBCUtil.getConnect();
            insert = poetDAO.insert(connect, lb);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(connect);
        }

        if (insert > 0) {
            System.out.println("插入成功！");
        } else {
            System.out.println("插入失败！");
        }
    }

    @Test
    public void testBatchInsert() {
        int insert = 0;
        Connection connect = null;
        try {
            Poet p1 = new Poet(2, "杜甫", new Date(-41245257943000L));
            Poet p2 = new Poet(3, "白居易", new Date(-41245257943000L));
            Poet[] poets = {p1, p2};
            connect = JDBCUtil.getConnect();
            insert = poetDAO.insert(connect, poets);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(connect);
        }

        if (insert > 0) {
            System.out.println("插入成功！");
        } else {
            System.out.println("插入失败！");
        }
    }

    @Test
    public void testDelete() {
        int insert = 0;
        Connection connect = null;
        try {
            connect = JDBCUtil.getConnect();
            insert = poetDAO.deleteById(connect, 4);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(connect);
        }

        if (insert > 0) {
            System.out.println("删除成功！");
        } else {
            System.out.println("删除失败！");
        }
    }

    @Test
    public void testBatchDelete() {
        int insert = 0;
        Connection connect = null;
        try {
            int[] ids = {5, 7, 8, 9, 10};
            connect = JDBCUtil.getConnect();
            insert = poetDAO.deleteById(connect, ids);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(connect);
        }

        if (insert > 0) {
            System.out.println("删除成功！");
        } else {
            System.out.println("删除失败！");
        }
    }

    @Test
    public void testUpdate() {
        int insert = 0;
        Connection connect = null;
        try {
            Poet p = new Poet(3, "白乐天", new Date(-41242257943000L));
            connect = JDBCUtil.getConnect();
            insert = poetDAO.update(connect, p);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(connect);
        }

        if (insert > 0) {
            System.out.println("更新成功！");
        } else {
            System.out.println("更新失败！");
        }
    }

    @Test
    public void testBatchUpdate() {
        int insert = 0;
        Connection connect = null;
        try {
            Poet p1 = new Poet(2, "杜子美", new Date(-41455257943000L));
            Poet p2 = new Poet(3, "白居易", new Date(-45245257943000L));
            Poet[] poets = {p1, p2};
            connect = JDBCUtil.getConnect();
            insert = poetDAO.update(connect, poets);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(connect);
        }

        if (insert > 0) {
            System.out.println("更新成功！");
        } else {
            System.out.println("更新失败！");
        }
    }

    @Test
    public void testQuery() {
        Poet res = null;
        Connection connect = null;
        try {
            connect = JDBCUtil.getConnect();
            res = poetDAO.getPoetById(connect, 2);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(connect);
        }

        if (res != null) {
            System.out.println("查询成功！");
            System.out.println(res);
        } else {
            System.out.println("查询失败！");
        }
    }
}
