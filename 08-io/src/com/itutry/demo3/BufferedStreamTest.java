package com.itutry.demo3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.Test;

public class BufferedStreamTest {

  @Test
  public void test1() {
    BufferedInputStream bis = null;
    BufferedOutputStream bos = null;
    try {
      File srcFile = new File("/Users/zhaozhang/Documents/毕业生技培/教学包/docker-and-docker-compose-basics/Docker and Docker Compose Basic-20200603.mp4");
      File destFile = new File("1.mp4");

      FileInputStream fis = new FileInputStream(srcFile);
      FileOutputStream fos = new FileOutputStream(destFile);

      bis = new BufferedInputStream(fis);
      bos = new BufferedOutputStream(fos);

      byte[] buff = new byte[1024];
      int len;
      while((len = bis.read(buff)) != -1) {
        bos.write(buff, 0, len);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (bos != null) {
        try {
          bos.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      if (bis != null) {
        try {
          bis.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  @Test
  public void test2() {
    long start = System.currentTimeMillis();

    String srcPath = "/Users/zhaozhang/Documents/毕业生技培/教学包/docker-and-docker-compose-basics/Docker and Docker Compose Basic-20200603.mp4";
    String destPath = "20200603.mp4";
    copyFiles(srcPath, destPath);

    long end = System.currentTimeMillis();
    System.out.println("复制文件花费的时间为：" + (end - start) + "ms");
  }

  @Test
  public void test3() {
    BufferedReader br = null;
    BufferedWriter bw = null;
    try {
      br = new BufferedReader(new FileReader(new File("dbcp.txt")));
      bw = new BufferedWriter(new FileWriter(new File("dbcp1.txt")));

      // 方式一
//      char[] buff = new char[1024];
//      int len;
//      while((len = br.read(buff)) != -1) {
//        bw.write(buff, 0, len);
//      }

      // 方式二
      String data;
      while((data = br.readLine()) != null) {
        bw.write(data);
//        bw.write("\n");
        bw.newLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (bw != null) {
        try {
          bw.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      if (br != null) {
        try {
          br.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  private void copyFiles(String srcPath, String destPath) {
    BufferedInputStream bis = null;
    BufferedOutputStream bos = null;
    try {
      File srcFile = new File(srcPath);
      File destFile = new File(destPath);

      FileInputStream fis = new FileInputStream(srcFile);
      FileOutputStream fos = new FileOutputStream(destFile);

      bis = new BufferedInputStream(fis);
      bos = new BufferedOutputStream(fos);

      byte[] buff = new byte[1024];
      int len;
      while((len = bis.read(buff)) != -1) {
        bos.write(buff, 0, len);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (bos != null) {
        try {
          bos.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      if (bis != null) {
        try {
          bis.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
