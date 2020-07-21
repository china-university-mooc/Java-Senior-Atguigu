package com.itutry.demo6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.junit.Test;

public class ObjectStreamTest {

  @Test
  public void test1() {
    ObjectOutputStream oos = null;
    try {
      oos = new ObjectOutputStream(
          new FileOutputStream("object.dat"));

      oos.writeObject(new String("我爱北京天安门"));
      oos.flush();

      oos.writeObject(new Person("张三", 18));
      oos.flush();

      oos.writeObject(new Person("张学良", 22, 1, new Account(200)));
      oos.flush();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (oos != null) {
        try {
          oos.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  @Test
  public void test2() {
    ObjectInputStream ois = null;
    try {
      ois = new ObjectInputStream(new FileInputStream("object.dat"));

      Object obj = ois.readObject();
      String str = (String) obj;
      System.out.println(str);

      Person p = (Person) ois.readObject();
      System.out.println(p);

      Person p1 = (Person) ois.readObject();
      System.out.println(p1);
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } finally {
      if (ois != null) {
        try {
          ois.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
