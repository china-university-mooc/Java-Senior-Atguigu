package com.itutry.test;

import org.junit.Test;

public class IDEADebug {

  @Test
  public void testStringBuilder() {
    String str = null;
    StringBuilder sb = new StringBuilder();
    sb.append(str);

    System.out.println(sb.length());

    System.out.println(sb);

    StringBuilder sb1 = new StringBuilder(str);
    System.out.println(sb1);
  }
}
