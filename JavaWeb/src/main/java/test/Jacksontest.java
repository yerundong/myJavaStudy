import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lib.User;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Jacksontest {

    /**
     * 序列化，将对象转化为json字符串
     */
    @Test
    public void test1() {
        User user = new User(1, "张三", 15);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String s = objectMapper.writeValueAsString(user);
            System.out.println(s);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 序列化，将list转化为json字符串
     */
    @Test
    public void test2() {
        User user1 = new User(1, "张三", 15);
        User user2 = new User(2, "李四", 15);
        ArrayList<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String s = objectMapper.writeValueAsString(users);
            System.out.println(s);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 反序列化，将json字符串转化为对象
     */
    @Test
    public void test3() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            User user = objectMapper.readValue("{\"id\":1,\"name\":\"张三\",\"age\":15}", User.class);
            // User user = objectMapper.readValue("{\"name\":\"张三\",\"id\":1,\"age\":15}", User.class);
            // User user = objectMapper.readValue("{\"id\":1,\"name\":\"张三\"}", User.class);
            System.out.println(user);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 反序列化，将json字符串转化为list
     */
    @Test
    public void test4() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            final String s = "[{\"id\":1,\"name\":\"张三\",\"age\":15},{\"id\":2,\"name\":\"李四\",\"age\":15}]";
            TypeReference<List<User>> typeReference = new TypeReference<List<User>>() {
            };
            List<User> list = objectMapper.readValue(s, typeReference);
            System.out.println(list);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 反序列化，将json字符串转化为map，并并处理
     */
    @Test
    public void test5() {
        ObjectMapper objectMapper = new ObjectMapper();
        final String s = "{\"id\":1,\"name\":\"张三\",\"age\":15}";
        try {
            TypeReference<HashMap> typeReference = new TypeReference<HashMap>() {
            };
            HashMap map = objectMapper.readValue(s, typeReference);
            map.remove("age");
            String s1 = objectMapper.writeValueAsString(map);
            System.out.println(s1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
