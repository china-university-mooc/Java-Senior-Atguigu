package com.itutry.test;

import org.junit.Test;

public class StringBufferBuilderTest {

  @Test
  public void test2() {
    StringBuffer s1 = new StringBuffer("abc");
    s1.append(1);
    s1.append("1");
    System.out.println(s1);
//    s1.delete(2, 4);
//    s1.replace(2, 4, "hello");
//    s1.insert(2, false);
    s1.reverse();
    System.out.println(s1);


  }

  @Test
  public void test1() {
    StringBuffer s1 = new StringBuffer("abc");
    s1.setCharAt(0, 'm');
    System.out.println(s1);
    s1.append("def");
    System.out.println(s1);
    System.out.println(s1.length());
  }
}
