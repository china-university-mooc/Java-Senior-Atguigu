package com.itutry.demo2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.Instant;
import org.junit.Test;

/**
 * 服务端读取图片并发送给客户端，客户端保存图片到本地
 */
public class TCPTest2 {

  @Test
  public void client() {
    Socket socket = null;
    OutputStream os = null;
    BufferedInputStream bis = null;
    try {
      socket = new Socket(InetAddress.getLocalHost(), 8888);
      os = socket.getOutputStream();

      bis = new BufferedInputStream(
          new FileInputStream("client.jpg"));

      System.out.println(Instant.now().toString() + "：开始发送文件");
      byte[] buff = new byte[1024];
      int len;
      while((len = bis.read(buff)) != -1) {
        os.write(buff, 0, len);
      }
      System.out.println(Instant.now().toString() + "：发送完毕");
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (bis != null) {
        try {
          bis.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
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
    ServerSocket serverSocket = new ServerSocket(8888);
    Socket socket = serverSocket.accept();
    InputStream is = socket.getInputStream();

    BufferedOutputStream bos = new BufferedOutputStream(
        new FileOutputStream("server.jpg"));
    System.out.println(Instant.now().toString() + "：开始接收文件");
    byte[] buff = new byte[1024];
    int len;
    while((len = is.read(buff)) != -1) {
      bos.write(buff, 0, len);
    }
    System.out.println(Instant.now().toString() + "：文件接收完毕");

    bos.close();
    is.close();
    socket.close();
    serverSocket.close();
  }
}
