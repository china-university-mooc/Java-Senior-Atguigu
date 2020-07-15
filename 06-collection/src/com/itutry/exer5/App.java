package com.itutry.exer5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 4. 对一个Java源文件中的关键字进行计数。
 * 提示:Java源文件中的每一个单词，需要确定该单词是否是一个关键字。为了高效处理这个问题，将所有的关键字保存在一个HashSet中。用contains() 来测试。
 */
public class App {

  public static void main(String[] args) {
    FileInputStream fis = null;
    try {
      fis = new FileInputStream(
          "06-collection/src/com/itutry/exer4/App.java");
      Scanner scanner = new Scanner(fis);

      HashSet set = new HashSet();
      set.add("for");
      set.add("public");

      HashMap map = new HashMap();
      while (scanner.hasNext()) {
        String word = scanner.next();
        if (set.contains(word)) {
          Integer num = (Integer) map.get(word);
          if (num == null) {
            num = 0;
          }
          map.put(word, num + 1);
        }
      }

      System.out.println("word\tcount");
      for(Object key : map.keySet()) {
        System.out.println(key + "\t" + map.get(key));
      }
    } catch (FileNotFoundException e) {
      System.out.println("文件找不到");
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
}
