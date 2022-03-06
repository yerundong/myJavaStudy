package servlet.请求转发;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Dispatched extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object to = request.getAttribute("to");
        System.out.println("to: " + to);

        if("dispatched".equals(to)){
            System.out.println("已转发成功，token合法");
        }else{
            System.out.println("已转发成功，但token不合法");
        }
    }
}
