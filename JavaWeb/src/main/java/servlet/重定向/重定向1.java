package servlet.重定向;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class 重定向1 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setStatus(302);
        // 方式一
        response.sendRedirect("redirect2");
        // 方式二
        // response.setHeader("Location", "redirect2");
        // 其他方式
        // ...
    }
}
