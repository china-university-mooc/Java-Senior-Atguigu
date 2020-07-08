package com.itutry.test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import org.junit.Test;

public class StringConvertTest {

  @Test
  public void test1() {
    char[] arr = new char[]{'a', 'b', 'c'};
    String s = new String(arr);
    System.out.println(s);
    char[] chars = s.toCharArray();
    System.out.println(Arrays.toString(chars));
  }

  @Test
  public void test2() throws UnsupportedEncodingException {
    String str = "123刘敏";
    byte[] bytes = str.getBytes();
    System.out.println(Arrays.toString(bytes));

    byte[] gbks = str.getBytes("GBK");
    System.out.println(Arrays.toString(gbks));
    String s = new String(bytes, 3, 3);
    System.out.println(s);
  }
}
