package com.itutry.java.demo3;

import java.io.IOException;
import java.io.InputStreamReader;

public class TryTest {

  public static void main(String[] args) {
    method3();
  }

  // JDK9
  private static void method3() {
    InputStreamReader reader = new InputStreamReader(System.in);
    try (reader) {
      char[] buff = new char[29];
      int len;
      if ((len = reader.read(buff)) != -1) {
        System.out.println(new String(buff, 0, len));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // JDK8
  private static void method2() {
    try (InputStreamReader reader = new InputStreamReader(System.in)) {
      char[] buff = new char[29];
      int len;
      if ((len = reader.read(buff)) != -1) {
        System.out.println(new String(buff, 0, len));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // JDK8前
  private static void method1() {
    InputStreamReader reader = null;
    try {
      reader = new InputStreamReader(System.in);

      char[] buff = new char[29];
      int len;
      if ((len = reader.read(buff)) != -1) {
        System.out.println(new String(buff, 0, len));
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (reader != null) {
        try {
          reader.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
