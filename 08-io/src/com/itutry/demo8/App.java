package com.itutry.demo8;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class App {

  public static void main(String[] args) {
    File src = new File("08-io/爱情与友情.jpg");
    File dest = new File("08-io/爱情与友情2.jpg");
    try {
      FileUtils.copyFile(src, dest);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
