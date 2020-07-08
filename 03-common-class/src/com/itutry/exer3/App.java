package com.itutry.exer3;

/**
 * 获取一个字符串在另一个字符串中出现的次数。
 * 比如:获取“ ab”在 “abkkcadkabkebfkabkskab” 中出现的次数
 */
public class App {

  public static void main(String[] args) {
    System.out.println(count("abkkcadkabkebfkabkskab", "ab"));
  }

  public static int count(String s, String sub) {
    if (s.length() < sub.length()) {
      return 0;
    }

    int count = 0;
    int start = 0;
    while (true) {
      int i = s.indexOf(sub, start);
      if (i < 0) {
        break;
      }

      count++;
      start = i + sub.length();
    }

    return count;
  }
}
