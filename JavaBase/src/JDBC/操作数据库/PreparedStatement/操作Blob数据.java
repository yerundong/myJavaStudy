package JDBC.操作数据库.PreparedStatement;

import JDBC.lib.JDBCUtil;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class 操作Blob数据 {
    // jdbc配置
    private final File JDBC_CONFIG = new File("JavaBase/src/JDBC/lib/jdbc.properties");
    private JDBCUtil jdbcUtil = new JDBCUtil(JDBC_CONFIG);

    /**
     * 插入数据库一条网络图片
     */
    @Test
    public void testInsert() {
        InputStream inputStream = null;
        try {
            URL url = new URL("https://alifei01.cfp.cn/creative/vcg/veer/1600water/veer-152663900.jpg");
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();
            huc.connect();
            inputStream = huc.getInputStream();
            String sql = "INSERT INTO `jdbc_blob` VALUES(?, ?)";
            int update = jdbcUtil.update(sql, 1, inputStream);
            if (update > 0) {
                System.out.println("更新成功！");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 查询并下载到本地
     */
    @Test
    public void testQuery() {
        Connection connection = jdbcUtil.getConnect();
        String sql = "SELECT * FROM `jdbc_blob` WHERE `id` = ?";
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, 1);
            resultSet = ps.executeQuery();
            if (resultSet.next()) {
                // 取得blob对象
                Blob bdata = resultSet.getBlob("bdata");
                System.out.println(bdata);

                // 取得io流
                InputStream binaryStream = bdata.getBinaryStream();
                bis = new BufferedInputStream(binaryStream);
                bos = new BufferedOutputStream(new FileOutputStream("IOTestFile/img/jdbc_blob.jpg"));
                int len;
                byte[] cbuf = new byte[1024];
                while ((len = bis.read(cbuf)) != -1) {
                    for (int i = 0; i < len; i++) {
                        bos.write(cbuf[i]);
                    }
                }
                System.out.println("下载成功！");
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();

                if (ps != null)
                    ps.close();

                if (connection != null)
                    connection.close();

                if (bis != null)
                    bis.close();

                if (bis != null)
                    bos.close();
            } catch (Exception throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
