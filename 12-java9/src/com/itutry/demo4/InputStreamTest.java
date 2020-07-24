package com.itutry.java.demo4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.junit.Test;

public class InputStreamTest {

  @Test
  public void test1() {
    try {
      FileInputStream fis = new FileInputStream("爱情与友情.jpg");
      FileOutputStream fos = new FileOutputStream("copy.jpg");
      try (fis; fos) {
        long len = fis.transferTo(fos);
        System.out.println(len);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
