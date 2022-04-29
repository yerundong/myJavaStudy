package servlet.请求转发;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Dispatch extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Content-Type", "text/html;charset=UTF-8");

        // 取到to参数
        String to = request.getParameter("to");
        request.setAttribute("to", to);

        RequestDispatcher requestDispatcher = null;
        if("dispatched".equals(to)){
            // 获取请求转发对象(转发给其他虚拟路径)
            requestDispatcher = request.getRequestDispatcher("/dispatched");
        }else if("WEB-INF".equals(to)){
            // 获取请求转发对象(转发其他资源)
            requestDispatcher = request.getRequestDispatcher("/WEB-INF/index.html");
        }else if("webXML".equals(to)){
            // 获取请求转发对象(转发其他资源)
            requestDispatcher = request.getRequestDispatcher("/WEB-INF/web.xml");
        }else if("dispProb".equals(to)){
            // 获取请求转发对象(转发其他资源)
            requestDispatcher = request.getRequestDispatcher("/转发时相对路径问题演示/");
        }

        // 进行传递
        if(requestDispatcher!=null){
            requestDispatcher.forward(request, response);
        }else{
            response.setStatus(500);
            // 写入字符数据
            PrintWriter writer = null;
            try {
                writer = response.getWriter();
                writer.write("to参数不合法！");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (writer != null) writer.close();
            }
        }
    }
}
