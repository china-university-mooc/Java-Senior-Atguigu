package com.itutry.java.demo4;

import org.junit.Test;

public class StringTest {

  @Test
  public void test1() {
    char[] chars = {'a', '我'};
    String s = new String(chars);
    System.out.println(s);
  }
}
