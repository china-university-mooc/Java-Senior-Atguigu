package com.itutry.demo3;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {

  public static void main(String[] args) throws IOException {
    FileInputStream fis = null;
    try {
      Properties pros = new Properties();

      fis = new FileInputStream("jdbc.properties");
      pros.load(fis);

      String name = pros.getProperty("name");
      String password = pros.getProperty("password");
      System.out.println("name = " + name + ", password = " + password);
    } finally {
      if (fis != null) {
        fis.close();
      }
    }
  }
}
