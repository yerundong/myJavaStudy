package 集合框架.Map;

import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/*
 @Properties：
     Properties 类位于 java.util.Properties，是Java 语言的配置文件所使用的类， Xxx.properties 为Java 语言常见的配置文件，
     如数据库的配置 jdbc.properties, 系统参数配置 system.properties。Properties 继承了Hashtable 类，以Map 的形式进行放置值
 */

public class Properties类 {
    @Test
    public void test() throws IOException {
        Properties properties = new Properties();
        FileReader fileReader = new FileReader("jdbc.properties");
        properties.load(fileReader);
        String userName = properties.getProperty("userName");
        String password = properties.getProperty("password");
        String abc = properties.getProperty("abc");
        System.out.println(userName);
        System.out.println(password);
        System.out.println(abc);

        fileReader.close();
    }
}
