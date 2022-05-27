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
        User user = mapper.readValue(params, User.class);
        User login = userServiceImpl.login(user);
        if (login == null) {
            resp.setStatus(500);
        }
    }
}
