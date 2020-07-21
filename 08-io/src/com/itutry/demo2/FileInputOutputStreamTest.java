package com.itutry.demo2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.junit.Test;

public class FileInputOutputStreamTest {

  @Test
  public void test1() {
    InputStream fis = null;
    OutputStream fos = null;
    try {
      File src = new File("01.jpg");
      File dest = new File("02.jpg");

      fis = new FileInputStream(src);
      fos = new FileOutputStream(dest);

      int data;
      while((data = fis.read()) != -1) {
        fos.write(data);
      }

//      byte[] buff = new byte[5];
//      int len;
//      while ((len = fis.read(buff)) != -1) {
//        fos.write(buff, 0, len);
//      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (fos != null) {
          fos.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      } finally {
        try {
          if (fis != null) {
            fis.close();
          }
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  @Test
  public void test2()  {
    FileInputStream fis = null;
    try {
      File file = new File("hello.txt");
      fis = new FileInputStream(file);

      byte[] buffer = new byte[5];
      int len;
      while((len = fis.read(buffer)) != -1) {
        System.out.print(new String(buffer, 0, len));
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (fis != null) {
        try {
          fis.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  @Test
  public void test3() {
    long start = System.currentTimeMillis();

    String srcPath = "/Users/zhaozhang/Documents/毕业生技培/教学包/docker-and-docker-compose-basics/Docker and Docker Compose Basic-20200603.mp4";
    String destPath = "20200603.mp4";

//    String srcPath = "hello.txt";
//    String destPath = "hello2.txt";

    copyFiles(srcPath, destPath);

    long end = System.currentTimeMillis();
    System.out.println("复制操作花费的时间为：" + (end - start) + "ms");
  }

  public void copyFiles(String srcPath, String destPath) {
    InputStream fis = null;
    OutputStream fos = null;
    try {
      File src = new File(srcPath);
      File dest = new File(destPath);

      fis = new FileInputStream(src);
      fos = new FileOutputStream(dest);

      byte[] buff = new byte[1024];
      int len;
      while ((len = fis.read(buff)) != -1) {
        fos.write(buff, 0, len);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (fos != null) {
          fos.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      } finally {
        try {
          if (fis != null) {
            fis.close();
          }
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
