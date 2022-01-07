package servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class HiServlet implements Servlet {
    public HiServlet() {
        System.out.println("1.构造器执行了");
    }

    /**
     * 初始化方法
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("2.init执行了");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * service方法专门用来出来请求和响应的
     * @param req 请求
     * @param res 响应
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("3.service执行了");

        // 处理请求
        HttpServletRequest hreq = (HttpServletRequest) req;
        String method = hreq.getMethod();
        if("GET".equals(method)){
            System.out.println("处理get请求");
        }else if("POST".equals(method)){
            System.out.println("处理post请求");
        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4.destroy执行了");
    }
}
