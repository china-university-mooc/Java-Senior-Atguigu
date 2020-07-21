package com.itutry.demo4;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.Test;

public class URLTest {

  @Test
  public void test1() throws MalformedURLException {
    URL url = new URL("http://localhost:8080/examples/beauty.jpg?name=Tom");

    System.out.println(url.getProtocol());
    System.out.println(url.getHost());
    System.out.println(url.getPort());
    System.out.println(url.getPath());
    System.out.println(url.getFile());
    System.out.println(url.getQuery());
  }

  @Test
  public void test2() throws IOException {
    URL url = new URL("http://localhost:8080/examples/beauty.jpg");
    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
    urlConnection.connect();

    InputStream is = urlConnection.getInputStream();
    BufferedOutputStream bos = new BufferedOutputStream(
        new FileOutputStream("b.jpg"));

    byte[] buff = new byte[1024];
    int len;
    while((len = is.read(buff)) != -1) {
      bos.write(buff, 0, len);
    }
    System.out.println("下载完成");

    bos.close();
    is.close();
    urlConnection.disconnect();
  }
}
