package com.itutry.demo3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import org.junit.Test;

public class UDPTest {

  @Test
  public void sender() throws IOException {
    DatagramSocket socket = new DatagramSocket();

    byte[] data = "我是UDP数据".getBytes();
    InetAddress ip = InetAddress.getByName("127.0.0.1");
    DatagramPacket packet = new DatagramPacket(data, 0, data.length, ip, 9999);

    socket.send(packet);

    socket.close();
  }

  @Test
  public void receiver() throws IOException {
    DatagramSocket socket = new DatagramSocket(9999);

    byte[] buff = new byte[200];
    DatagramPacket packet = new DatagramPacket(buff, 0, buff.length);
    socket.receive(packet);

    System.out.println(new String(packet.getData(), 0, packet.getLength()));
  }
}
