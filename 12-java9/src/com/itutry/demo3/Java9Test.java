package com.itutry.java.demo3;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Comparator;
import org.junit.Test;

public class Java9Test {

  @Test
  public void test1() {
    try {
      URL url = new URL("http://www.atguigu.com");
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void test2() {
    Comparator<Integer> com = new Comparator<>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return Integer.compare(o1, o2);
      }
    };

    System.out.println(com.compare(12, 21));
  }
}
