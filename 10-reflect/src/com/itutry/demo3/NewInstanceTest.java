package com.itutry.demo3;

import com.itutry.demo1.Person;
import java.util.Random;
import org.junit.Test;

public class NewInstanceTest {

  @Test
  public void test1() throws IllegalAccessException, InstantiationException {
    Class<Person> clazz = Person.class;

    Person obj = clazz.newInstance();
    System.out.println(obj);
  }

  @Test
  public void test2() {

    for (int i = 0; i < 10; i++) {
      int num = new Random().nextInt(3);
      String classPath = "";
      switch (num) {
        case 0:
          classPath = "java.util.Date";
          break;
        case 1:
          classPath = "java.lang.Object";
          break;
        case 2:
          classPath = "com.itutry.demo1.Person";
          break;
      }
      try {
        Object obj = getInstance(classPath);
        System.out.println(obj);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  private Object getInstance(String classPath) throws Exception {
    Class<?> clazz = Class.forName(classPath);
    return clazz.newInstance();
  }
}
