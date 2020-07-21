package com.itutry.demo2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import org.junit.Test;

/**
 * 服务端读取图片并发送给客户端，客户端保存图片到本地，并返回"发送成功"给客户端
 */
public class TCPTest3 {

  @Test
  public void client() throws IOException {
    Socket socket = new Socket(InetAddress.getLocalHost(), 8888);

    OutputStream os = socket.getOutputStream();
    BufferedInputStream bis = new BufferedInputStream(
        new FileInputStream("client.jpg"));
    byte[] buff = new byte[1024];
    int len;
    while((len = bis.read(buff)) != -1) {
      os.write(buff, 0, len);
    }
    socket.shutdownOutput();

    InputStream is = socket.getInputStream();
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    byte[] buff1 = new byte[1024];
    int len1;
    while((len1 = is.read(buff1)) != -1) {
      baos.write(buff1, 0, len1);
    }
    System.out.println(baos.toString());

    baos.close();
    is.close();

    bis.close();
    os.close();

    socket.close();
  }

  @Test
  public void server() throws IOException {
    ServerSocket serverSocket = new ServerSocket(8888);
    Socket socket = serverSocket.accept();

    InputStream is = socket.getInputStream();
    BufferedOutputStream bos = new BufferedOutputStream(
        new FileOutputStream("server.jpg"));
    byte[] buff = new byte[1024];
    int len;
    while((len = is.read(buff)) != -1) {
      bos.write(buff, 0, len);
    }
    System.out.println("图片传输完成");

    OutputStream os = socket.getOutputStream();
    os.write("发送成功".getBytes());
    os.close();

    bos.close();
    is.close();

    socket.close();
    serverSocket.close();
  }
}
