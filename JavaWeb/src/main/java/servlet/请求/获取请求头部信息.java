package servlet.请求;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Enumeration;

public class 获取请求头部信息 extends HttpServlet {
    private void sout(HttpServletRequest request, HttpServletResponse response){
        System.out.println("getHeader: " + request.getHeader("Cookie"));
        System.out.println("getHeaders: " + request.getHeaders("Cookie"));

        Enumeration<String> headerNames = request.getHeaderNames();
        System.out.println("-- headerNames --");
        while (headerNames.hasMoreElements()) {
            System.out.println(headerNames.nextElement());
        }
        System.out.println("-- headerNames --");

        System.out.println("getContentType: " + request.getContentType());
        System.out.println("getContentLength: " + request.getContentLength());
        System.out.println("getCharacterEncoding: " + request.getCharacterEncoding());
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        System.out.println("--------------------- get ---------------------");
        sout(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        System.out.println("--------------------- post ---------------------");
        sout(request, response);
    }
}
