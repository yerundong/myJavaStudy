package servlet.请求;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

public class 获取请求行信息 extends HttpServlet {
    private void sout(HttpServletRequest request, HttpServletResponse response){
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
