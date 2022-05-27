package controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pojo.User;
import service.UserServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

public class RegisterServlet extends HttpServlet {
    private final UserServiceImpl userServiceImpl = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader br = req.getReader();
        String params = br.readLine();
        ObjectMapper mapper = new ObjectMapper();
        final HashMap hashMap = mapper.readValue(params, new TypeReference<HashMap>() {
        });
        hashMap.remove("passwordAgain");
        String s = mapper.writeValueAsString(hashMap);
        User user = mapper.readValue(s, User.class);
        Boolean register = userServiceImpl.register(user);
        if (!register) {
            resp.setStatus(500);
        }
    }
}
