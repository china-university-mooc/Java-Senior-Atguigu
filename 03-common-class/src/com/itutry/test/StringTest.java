package com.itutry.test;

import org.junit.Test;

public class StringTest {

  @Test
  public void test3() {
    String s1 = "javaEE";
    String s2 = "hadoop";
    final String s9 = "javaEE";

    String s3 = "javaEEhadoop";
    String s4 = "javaEE" + "hadoop";
    String s5 = "javaEE" + s2;
    String s6 = s1 + "hadoop";
    String s7 = s1 + s2;
    String s10 = s9 + "hadoop";


    System.out.println(s3 == s4);
    System.out.println(s3 == s5);
    System.out.println(s3 == s6);
    System.out.println(s3 == s7);

    System.out.println(s5 == s6);
    System.out.println(s5 == s7);

    String s8 = s5.intern();
    System.out.println(s3 == s8);
    System.out.println(s3 == s10);
  }

  @Test
  public void test2() {
    String s1 = "javaEE";
    String s2 = new String("javaEE");
    String s3 = new String("javaEE");
    System.out.println(s1 == s2);
    System.out.println(s2 == s3);
  }

  @Test
  public void test1() {
    String s1 = "abc";
    String s2 = "abc";
    System.out.println(s1 == s2);

    String s3 = "abc";
    System.out.println(System.identityHashCode(s3));
    s3 += "def";
    System.out.println(System.identityHashCode(s3));

    String s4 = "abc";
    String s5 = s4.replace('a', 'm');
    System.out.println(s4);
    System.out.println(s5);
  }
}
