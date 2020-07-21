package com.itutry.demo2;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import org.junit.Test;

public class FileReaderWriterTest {

  @Test
  public void test1() {
    FileReader fr = null;
    try {
      File file = new File("hello.txt");
      fr = new FileReader(file);

    int data = fr.read();
    while (data != -1) {
      System.out.print((char) data);
      data = fr.read();
    }

//      int data;
//      while ((data = fr.read()) != -1) {
//        System.out.print((char) data);
//      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (fr != null) {
        try {
          fr.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  @Test
  public void test2() {
    Reader fr = null;
    try {
      File file = new File("hello.txt");
      fr = new FileReader(file);

      char[] cbuf = new char[5];
      int len;
      while ((len = fr.read(cbuf)) != -1) {
//        for (int i = 0; i < cbuf.length; i++) {
//          System.out.print(cbuf[i]);
//        }

//        for (int i = 0; i < len; i++) {
//          System.out.print(cbuf[i]);
//        }

        System.out.print(new String(cbuf, 0, len));
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (fr != null) {
        try {
          fr.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  @Test
  public void test3() {
    Writer fw = null;
    try {
      File file = new File("hi.txt");
//      fw = new FileWriter(file, true);
      fw = new FileWriter(file);

      fw.write("i have a dream!\n".toCharArray());
      fw.write("you need to have a dream!\n");
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (fw != null) {
        try {
          fw.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  @Test
  public void test4() {
    FileReader fr = null;
    FileWriter fw = null;
    try {
      File src = new File("hello.txt");
      File dest = new File("hello2.txt");

//      File src = new File("01.jpg");
//      File dest = new File("02.jpg");

      fr = new FileReader(src);
      fw = new FileWriter(dest);

      char[] cbuf = new char[5];
      int len;
      while ((len = fr.read(cbuf)) != -1) {
        fw.write(cbuf, 0, len);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
//      try {
//        if (fw != null) {
//          fw.close();
//        }
//      } catch (IOException e) {
//        e.printStackTrace();
//      }
//
//      try {
//        if (fr != null) {
//          fr.close();
//        }
//      } catch (IOException e) {
//        e.printStackTrace();
//      }

      try {
        if (fw != null) {
          fw.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      } finally {
        try {
          if (fr != null) {
            fr.close();
          }
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
