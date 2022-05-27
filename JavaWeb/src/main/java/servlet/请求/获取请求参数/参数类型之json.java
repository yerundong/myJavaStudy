package servlet.请求.获取请求参数;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lib.Foo;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * 获取Content-Type=application/json的参数
 * 凭io流获取，再使用工具类jackson/fastjson解析
 */
public class 参数类型之json extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("--------------------- post ---------------------");
        BufferedReader br = request.getReader();
        String params = br.readLine();// 获取json字符串
        System.out.println(params);
        // json转对象
        ObjectMapper mapper = new ObjectMapper();
        Foo foo = mapper.readValue(params, Foo.class);
        System.out.println(foo);
    }
}
