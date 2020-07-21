package com.itutry.exer1;

import java.io.File;

public class App {

  public static void main(String[] args) {
//    File file = new File("/Users/zhaozhang/Documents/Course/Projects/Java-Senior-Atguigu/08-io");
//    print(file, "");
//    System.out.println(size(file));

//    new File("08-io/a/b/hi.txt").mkdirs();
//    new File("08-io/a/b/c/hi.txt").mkdirs();
//    new File("08-io/a/hi.txt").mkdirs();

    File file = new File("08-io/a");
    delete(file);
  }

  private static void print(File file, String prefix) {
    System.out.println(prefix + file.getName());
    if (file.isDirectory()) {
      File[] files = file.listFiles();
      for(File f: files) {
        print(f, prefix + "\t");
      }
    }
  }

  private static long size(File file) {
    if (file.isFile()) {
      return file.length();
    }

    long sum = 0;
    File[] files = file.listFiles();
    for(File f: files) {
      sum += size(f);
    }
    return sum;
  }

  private static void delete(File file) {
    if (file.isDirectory()) {
      File[] files = file.listFiles();
      for(File f: files) {
        delete(f);
      }
    }

    file.delete();
  }
}
