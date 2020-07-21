package com.itutry.demo1;

import java.net.InetAddress;
import java.net.UnknownHostException;
import org.junit.Test;

public class InetAddressTest {

  @Test
  public void test1() {
    try {
      InetAddress inet1 = InetAddress.getByName("192.168.0.107");
      System.out.println(inet1);

      InetAddress inet2 = InetAddress.getByName("www.atguigu.com");
      System.out.println(inet2);

      InetAddress inet3 = InetAddress.getByName("localhost");
      System.out.println(inet3);

      InetAddress inet4 = InetAddress.getLocalHost();
      System.out.println(inet4);

      System.out.println(inet2.getHostName());
      System.out.println(inet2.getHostAddress());
    } catch (UnknownHostException e) {
      e.printStackTrace();
    }
  }
}
