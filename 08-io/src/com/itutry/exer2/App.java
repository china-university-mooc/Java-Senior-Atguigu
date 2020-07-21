package com.itutry.exer2;

import java.io.File;
import org.junit.Test;

public class App {

  @Test
  public void test() {
    File file = new File("a");
    if (file.isDirectory()) {
      File[] files = file.listFiles();
      for (File f : files) {
        if (f.getName().endsWith(".jpg")) {
          System.out.println(f.getName());
        }
      }
    }
  }
}
