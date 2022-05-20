package servlet.请求.获取请求参数;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * 获取Content-Type=application/json的参数
 * 凭io流获取，再使用工具类jackson解析
 */
public class 参数类型3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("--------------------- post ---------------------");
        BufferedReader br = request.getReader();
        String params = br.readLine();
        System.out.println(params);
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.readValue(params, ObjectNode.class);
        String bar = node.get("bar").asText();
        String foo = node.get("foo").asText();
        System.out.println(bar);
        System.out.println(foo);
    }
}
