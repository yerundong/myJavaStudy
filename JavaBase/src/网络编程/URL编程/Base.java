package 网络编程.URL编程;

import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Base {
    /**
     * @
     */
    @Test
    public void test() {
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            URL url = new URL("http://www.lei.com/images/newleilogo2.gif");
            System.out.println(url.getPath());// /images/newleilogo2.gif
            System.out.println(url.getHost());// www.lei.com
            System.out.println(url.getPort());
            System.out.println(url.getQuery());
            System.out.println(url.getProtocol());// http

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();
            is = urlConnection.getInputStream();
            fos = new FileOutputStream("IOTestFile/img/下载.gif");
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (fos != null) {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
