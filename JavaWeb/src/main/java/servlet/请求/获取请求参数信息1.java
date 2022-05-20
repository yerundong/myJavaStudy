package servlet.请求;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

public class 获取请求参数信息 extends HttpServlet {
    private void sout(HttpServletRequest request, HttpServletResponse response){
        String a = request.getParameter("a");
        String b = request.getParameter("b");
        String c = request.getParameter("c");
        String bar = request.getParameter("bar");
        String foo = request.getParameter("foo");
        System.out.println("getParameter: a=" + a);
        System.out.println("getParameter: b=" + b);
        System.out.println("getParameter: c=" + c);
        System.out.println("getParameter: bar=" + bar);
        System.out.println("getParameter: foo=" + foo);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        System.out.println("--------------------- get ---------------------");
        sout(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        System.out.println("--------------------- post ---------------------");
        sout(request, response);

        // 取多个相同名称的参数的值
        System.out.println("getParameterValues: c=" + Arrays.toString(request.getParameterValues("c")));
        String[] foos = request.getParameterValues("foo");
        System.out.println("getParameterValues: foos=" + Arrays.toString(foos));

        Enumeration<String> parameterNames = request.getParameterNames();
        System.out.println("-- getParameterNames --");
        while (parameterNames.hasMoreElements()) {
            System.out.println(parameterNames.nextElement());
        }
        System.out.println("-- getParameterNames --");
    }
}
