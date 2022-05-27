package servlet.请求.获取请求参数;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;

/**
 * 获取Content-Type=multipart/form-data的参数
 * 无法使用request.getParameter可获取form-data参数，需要使用io流读取（字符流或字节流）
 */
public class 参数类型之formData extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("--------------------- post ---------------------");
        // 第一种方式：io流
        // BufferedReader reader = null;
        // try {
        //     reader = request.getReader();
        //     char[] cbuf = new char[1024];
        //     int len;
        //     StringBuilder sb = new StringBuilder();
        //     while ((len = reader.read(cbuf)) != -1) {
        //         sb.append(new String(cbuf, 0, len));
        //     }
        //     reader.close();
        //     System.out.println(sb);// 还需要后续解析步骤
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

        // 第二种方式：Servlet 3.0以上可以使用getParts，需要在web.xml里配置<multipart-config>配置
        try {
            Collection<Part> parts = request.getParts();
            for (Part part : parts) {
                System.out.println("name:" + part.getName());

                InputStream inputStream = part.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                char[] cbuf = new char[1024];
                int len;
                StringBuilder sb = new StringBuilder();
                while ((len = inputStreamReader.read(cbuf)) != -1) {
                    sb.append(new String(cbuf, 0, len));
                }
                System.out.println("value:" + sb);

                inputStream.close();
                inputStreamReader.close();
            }
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }
}
