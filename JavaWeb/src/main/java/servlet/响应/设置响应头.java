package servlet.响应;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

public class 设置响应头 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        // 或者
        // response.setContentType("text/html;charset=UTF-8");
        response.setHeader("abc", "123");
        System.out.println(response.getContentType());

        // 写入字符数据
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.write("好哇");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) writer.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
