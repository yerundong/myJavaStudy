package DAO;

import lib.jdbcUtils;
import lib.Poet;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

public class TestDAO {
    public PoetDAOImpl poetDAO = new PoetDAOImpl();

    @Test
    public void testInsert() {
        int insert = 0;
        Connection connect = null;
        try {
            Poet lb = new Poet(1, "李白", new Date(-31245257943000L));
            connect = jdbcUtils.getConnect();
            insert = poetDAO.insert(connect, lb);
        } catch (Exception e) {
            e.printStackTrace();
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
            connect = jdbcUtils.getConnect();
            insert = poetDAO.insert(connect, poets);
        } catch (Exception e) {
            e.printStackTrace();
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
            connect = jdbcUtils.getConnect();
            insert = poetDAO.deleteById(connect, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (insert > 0) {
            System.out.println("删除成功！");
        } else {
            System.out.println("删除失败！");
        }
    }

    @Test
    public void testBatchDelete() {
        int count = 0;
        Connection connect = null;
        try {
            int[] ids = {1, 2, 8, 9, 10};
            connect = jdbcUtils.getConnect();
            count = poetDAO.deleteById(connect, ids);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (count > 0) {
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
            connect = jdbcUtils.getConnect();
            insert = poetDAO.update(connect, p);
        } catch (Exception e) {
            e.printStackTrace();
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
            connect = jdbcUtils.getConnect();
            insert = poetDAO.update(connect, poets);
        } catch (Exception e) {
            e.printStackTrace();
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
            connect = jdbcUtils.getConnect();
            res = poetDAO.getPoetById(connect, 2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (res != null) {
            System.out.println("查询成功！");
            System.out.println(res);
        } else {
            System.out.println("查询失败！");
        }
    }

    @Test
    public void testQueryName() {
        List<Poet> res = null;
        Connection connect = null;
        try {
            connect = jdbcUtils.getConnect();
            res = poetDAO.getPoetByName(connect, "白居易");
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (res != null) {
            System.out.println("查询成功！");
            System.out.println(res.get(0));
        } else {
            System.out.println("查询失败！");
        }
    }
}
