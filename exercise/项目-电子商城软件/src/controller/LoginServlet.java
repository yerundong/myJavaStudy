package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pojo.User;
import service.UserServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private final UserServiceImpl userServiceImpl = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader br = req.getReader();
        String params = br.readLine();  //json字符串
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.readValue(params, ObjectNode.class);
        String name = node.get("name").asText();
        String password = node.get("password").asText();
        if (name == null || password  == null) {
            resp.setStatus(500);
        } {
            User user = new User(name, password);
            User login = userServiceImpl.login(user);
            if(login == null){
                resp.setStatus(500);
            }
        }
    }
}
