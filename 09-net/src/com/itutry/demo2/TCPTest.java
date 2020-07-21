package com.itutry.demo2;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import org.junit.Test;

public class TCPTest {

  @Test
  public void client() {
    Socket socket = null;
    OutputStream os = null;
    try {
      InetAddress inet = InetAddress.getByName("localhost");
      socket = new Socket(inet, 8888);

      os = socket.getOutputStream();

      os.write("你好，我是客户端".getBytes());
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (os != null) {
        try {
          os.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      if (socket != null) {
        try {
          socket.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  @Test
  public void server() throws IOException {
    ServerSocket ss = new ServerSocket(8888);

    Socket socket = ss.accept();
    InputStream is = socket.getInputStream();

    // 方法一：ByteArrayOutputStream
//    ByteArrayOutputStream baos = new ByteArrayOutputStream();
//    byte[] buff = new byte[10];
//    int len;
//    while((len = is.read(buff)) != -1) {
//        baos.write(buff, 0, len);
//    }
//
//    System.out.println(baos.toString());
//
//    baos.close();
//    is.close();
//    socket.close();
//    ss.close();

    // 方法二：OutputStreamWriter
    InputStreamReader osr = new InputStreamReader(is);
    char[] buff = new char[5];
    int len;
    while((len = osr.read(buff)) != -1) {
      System.out.print(new String(buff, 0, len));
    }
    System.out.println();
    System.out.println("接收到来自" + socket.getInetAddress().getHostAddress() + "的数据");

    osr.close();
    socket.close();
    ss.close();
  }
}
