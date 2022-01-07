package servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetServletConfig extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("getServletName: " + getServletName());
        System.out.println("key1: " + getInitParameter("key1"));
        System.out.println("key2: " + getInitParameter("key2"));

        // ServletConfig表示整个servlet的配置信息对象
        ServletConfig servletConfig = getServletConfig();
        System.out.println("servletConfig: " + servletConfig);

        // ServletContext表示上下文对象
        ServletContext servletContext = getServletContext();
        System.out.println("servletContext: " + servletContext);
        System.out.println("context1: " + servletContext.getInitParameter("context1"));
        System.out.println("context2: " + servletContext.getInitParameter("context2"));
        System.out.println("getRequestCharacterEncoding: " + servletContext.getRequestCharacterEncoding());
        System.out.println("getResponseCharacterEncoding: " + servletContext.getResponseCharacterEncoding());
        // 获取当前工程上下文路径
        System.out.println("getContextPath: " + servletContext.getContextPath());
    }
}
