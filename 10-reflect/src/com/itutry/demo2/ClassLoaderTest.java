package com.itutry.demo2;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.junit.Test;

public class ClassLoaderTest {

  @Test
  public void test1() {
    ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
    System.out.println(classLoader);

    ClassLoader classLoader1 = classLoader.getParent();
    System.out.println(classLoader1);

    ClassLoader classLoader2 = classLoader1.getParent();
    System.out.println(classLoader2);

    System.out.println(String.class.getClassLoader());
  }

  @Test
  public void test2() throws IOException {
    Properties pros = new Properties();

    //方式一
//    FileInputStream fis = new FileInputStream("jdbc.properties");
//    pros.load(fis);

    InputStream is = ClassLoaderTest.class.getClassLoader()
        .getResourceAsStream("jdbc.properties");
    pros.load(is);

    String user = pros.getProperty("user");
    String password = pros.getProperty("password");
    System.out.println("user=" + user + ",password=" + password);
  }
}
