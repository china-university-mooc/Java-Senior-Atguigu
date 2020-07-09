package com.itutry.test;

import org.junit.Test;

public class SystemTest {

  @Test
  public void test1() {
//    System.out.println(System.getProperties());
    System.out.println(System.getProperty("java.version"));
    System.out.println(System.getProperty("java.home"));
    System.out.println(System.getProperty("os.name"));
    System.out.println(System.getProperty("os.version"));
    System.out.println(System.getProperty("user.dir"));
    System.out.println(System.getProperty("user.name"));
    System.out.println(System.getProperty("user.home"));
  }
}
