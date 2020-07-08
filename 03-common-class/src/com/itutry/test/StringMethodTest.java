package com.itutry.test;

import org.junit.Test;

public class StringMethodTest {

  @Test
  public void test3() {
    String s1 = "北京西京东京南京";
    System.out.println(s1.replace('京', '城'));
    System.out.println(s1.replace("京", "城"));
    System.out.println(s1.replaceAll("京", "城"));
    System.out.println(s1.replaceFirst("京", "城"));

    System.out.println("abc3d5".replaceAll("\\d+", ""));
  }

  @Test
  public void test2() {
    String s1 = "hello world";
    System.out.println(s1.endsWith("rld"));
    System.out.println(s1.startsWith("he"));
    System.out.println(s1.startsWith("ll", 2));
  }

  @Test
  public void test1() {
    System.out.println(" hello world ".trim());
    System.out.println("abc".concat("def"));
    System.out.println("abcdef".substring(1, 3));
  }
}
