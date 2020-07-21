package com.itutry.demo1;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.util.Arrays;
import org.junit.Test;

public class FileTest {

  @Test
  public void test1() {
    File file1 = new File("hello.txt");
//    System.out.println(file1.getAbsolutePath())
//    System.out.println(File.separator);
    File file2 = new File(
        "/Users/zhaozhang/Documents/Course/Projects/Java-Senior-Atguigu/08-io/he.txt");
    System.out.println(file1);
    System.out.println(file2);

    File file3 = new File("/Users/zhaozhang/Documents/Course/Projects/Java-Senior-Atguigu",
        "08-io");
    System.out.println(file3);

    File file4 = new File(file3, "hi.txt");
    System.out.println(file4);
  }

  @Test
  public void test2() {
    File file1 = new File("hello.txt");
    File file2 = new File(
        "/Users/zhaozhang/Documents/Course/Projects/Java-Senior-Atguigu/08-io/hi.txt");

    System.out.println(file1.getAbsolutePath());
    System.out.println(file1.getPath());
    System.out.println(file1.getName());
    System.out.println(file1.getParent());
    System.out.println(file1.length());
    System.out.println(Instant.ofEpochMilli(file1.lastModified()));

    System.out.println();
    System.out.println(file2.getAbsolutePath());
    System.out.println(file2.getPath());
    System.out.println(file2.getName());
    System.out.println(file2.getParent());
    System.out.println(file2.length());
    System.out.println(file2.lastModified());
  }

  @Test
  public void test3() {
    File file = new File(
        "/Users/zhaozhang/Documents/Course/Projects/Java-Senior-Atguigu/08-io");

    String[] names = file.list();
    System.out.println(Arrays.toString(names));

    File[] files = file.listFiles();
    for (File f : files) {
      System.out.println(f);
    }
  }

  @Test
  public void test4() {
    File file1 = new File("hello.txt");
    File file2 = new File("generated/hi.txt");

    System.out.println(file2.renameTo(file1));
  }

  @Test
  public void test5() {
    File file1 = new File("hello.txt");
    File file2 = new File("/Users/zhaozhang/Documents/Course/Projects/Java-Senior-Atguigu/08-io");

    System.out.println(file1.isDirectory());
    System.out.println(file1.isFile());
    System.out.println(file1.exists());
    System.out.println(file1.canRead());
    System.out.println(file1.canWrite());
    System.out.println(file1.isHidden());

    System.out.println();
    System.out.println(file2.isDirectory());
    System.out.println(file2.isFile());
    System.out.println(file2.exists());
    System.out.println(file2.canRead());
    System.out.println(file2.canWrite());
    System.out.println(file2.isHidden());
  }

  @Test
  public void test6() throws IOException {
    File file1 = new File("hi.txt");
    if (!file1.exists()) {
      System.out.println(file1.createNewFile());
      System.out.println("创建成功");
    } else {
      System.out.println(file1.delete());
      System.out.println("删除成功");
    }
  }

  @Test
  public void test7() {
    File file2 = new File("a/b");
    if (file2.mkdir()) {
      System.out.println("创建a/b成功");
    }

    File file3 = new File("a/c");
    if (file3.mkdirs()) {
      System.out.println("创建a/c成功");
    }
  }

//  public static void main(String[] args) {
//    File file1 = new File("hello.txt");
//    System.out.println(file1.getAbsolutePath());
//  }
}
