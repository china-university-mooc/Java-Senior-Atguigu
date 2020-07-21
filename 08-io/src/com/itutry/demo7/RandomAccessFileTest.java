package com.itutry.demo7;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import org.junit.Test;

public class RandomAccessFileTest {

  @Test
  public void test1() {
    RandomAccessFile raf1 = null;
    RandomAccessFile raf2 = null;
    try {
      raf1 = new RandomAccessFile(new File("爱情与友情.jpg"), "r");
      raf2 = new RandomAccessFile(new File("爱情与友情1.jpg"), "rw");

      byte[] buff = new byte[1024];
      int len;
      while ((len = raf1.read(buff)) != -1) {
        raf2.write(buff, 0, len);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (raf1 != null) {
        try {
          raf1.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      if (raf2 != null) {
        try {
          raf2.close();
        } catch (IOException e) {
          e.printStackTrace();
        }

      }
    }

  }

  @Test
  public void test3() throws IOException {
    RandomAccessFile raf = new RandomAccessFile(new File("hello.txt"), "rw");

    raf.seek(3);
    raf.write("xyz".getBytes());

    raf.close();
  }

  @Test
  public void test5() throws IOException {
    // 插入
    File file = new File("hello.txt");
    RandomAccessFile raf = new RandomAccessFile(file, "rw");
    int pos = 3;
    raf.seek(pos);

    // 方式一
//    byte[] buff = new byte[(int) (file.length() - pos)];
//    raf.read(buff);
//
//    raf.seek(3);
//    raf.write("xyz".getBytes());
//    raf.write(buff);

    // 方式二
//    StringBuilder sb = new StringBuilder((int) (file.length() - pos));
//    byte[] buff = new byte[10];
//    int len;
//    while((len = raf.read(buff)) != -1) {
//      sb.append(new String(buff, 0, len));
//    }
//
//    raf.seek(pos);
//    raf.write("xyz".getBytes());
//    raf.write(sb.toString().getBytes());

    // 方式三
    ByteArrayOutputStream baos = new ByteArrayOutputStream((int) file.length());
    byte[] buff = new byte[5];
    int len;
    while ((len = raf.read(buff)) != -1) {
      baos.write(buff, 0, len);
    }

    raf.seek(pos);
    raf.write("xyz".getBytes());
    raf.write(baos.toByteArray());

    raf.close();
  }

  @Test
  public void test4() throws IOException {
    // 追加
    File file = new File("hello.txt");
    RandomAccessFile raf = new RandomAccessFile(file, "rw");

    raf.seek(file.length() - 1);
//    raf.seek(100);
    raf.write("xyz".getBytes());

    raf.close();
  }
}
