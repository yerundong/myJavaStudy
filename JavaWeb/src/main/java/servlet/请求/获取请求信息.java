package servlet.请求;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

public class 获取请求信息 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        // 设置请求字符集编码
        // request.setCharacterEncoding("UTF-8");

        // 获取请求行信息的相关方法
        System.out.println("---------------- 获取请求行信息的相关方法 --------------------");
        System.out.println("getMethod: " + request.getMethod());
        System.out.println("getRequestURI: " + request.getRequestURI());
        System.out.println("getRequestURL: " + request.getRequestURL());
        System.out.println("getQueryString : " + request.getQueryString());
        System.out.println("getContextPath : " + request.getContextPath());
        System.out.println("getPathInfo : " + request.getPathInfo());
        System.out.println("getServletPath : " + request.getServletPath());
        System.out.println("getRemoteAddr: " + request.getRemoteAddr());
        System.out.println("getRemoteHost: " + request.getRemoteHost());
        System.out.println("getRemotePort: " + request.getRemotePort());
        System.out.println("getLocalAddr: " + request.getLocalAddr());
        System.out.println("getLocalName: " + request.getLocalName());
        System.out.println("getLocalPort: " + request.getLocalPort());
        System.out.println("getServerName: " + request.getServerName());
        System.out.println("getServerPort: " + request.getServerPort());
        System.out.println("getRequestURL: " + request.getRequestURL());

        System.out.println("---------------- 获取请求消息头的相关方法 --------------------");
        System.out.println("getHeader: " + request.getHeader("Cookie"));
        System.out.println("getHeaders: " + request.getHeaders("Cookie"));

        Enumeration<String> headerNames = request.getHeaderNames();
        System.out.println("↓ headerNames ↓");
        while (headerNames.hasMoreElements()) {
            System.out.println(headerNames.nextElement());
        }
        System.out.println("↑ headerNames ↑");

        System.out.println("getContentType: " + request.getContentType());
        System.out.println("getContentLength: " + request.getContentLength());
        System.out.println("getCharacterEncoding: " + request.getCharacterEncoding());

        System.out.println("---------------- 获取请求参数 --------------------");
        System.out.println("getParameter: a=" + request.getParameter("a"));
        System.out.println("getParameter: b=" + request.getParameter("b"));
        System.out.println("getParameter: c=" + request.getParameter("c"));
        System.out.println("getParameter: bar=" + request.getParameter("bar"));
        System.out.println("getParameter: foo=" + request.getParameter("foo"));

        // 取多个相同名称的参数的值
        System.out.println("getParameterValues: c=" + Arrays.toString(request.getParameterValues("c")));
        System.out.println("getParameterValues: foo=" + request.getParameterValues("foo")[0]);

        Enumeration<String> parameterNames = request.getParameterNames();
        System.out.println("↓ getParameterNames ↓");
        while (parameterNames.hasMoreElements()) {
            System.out.println(parameterNames.nextElement());
        }
        System.out.println("↑ getParameterNames ↑");

        Map<String, String[]> parameterMap = request.getParameterMap();
        System.out.println("↓ getParameterMap ↓");
        parameterMap.forEach((key, value) -> {
            System.out.println(key + "=" + value);
        });
        System.out.println("↑ getParameterMap ↑");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("getMethod: " + request.getMethod());
        System.out.println("getQueryString : " + request.getQueryString());
        System.out.println("getParameter: a=" + request.getParameter("a"));
        System.out.println("getParameter: b=" + request.getParameter("b"));
        System.out.println("getParameter: c=" + request.getParameter("c"));
        System.out.println("getParameter: bar=" + request.getParameter("bar"));
        System.out.println("getParameter: foo=" + request.getParameter("foo"));
        System.out.println("getParameterValues: c=" + Arrays.toString(request.getParameterValues("c")));
    }
}
