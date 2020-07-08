package com.itutry.exer1;

/**
 * 模拟一个trim方法，去除字符串两端的空格。
 */
public class App {

  public static void main(String[] args) {
    String s1 = "   Hello World  ";
    String s2 = trim(s1);
    System.out.println("---" + s2 + "---");
  }

  public static String trim(String s) {
    int start = 0;
    while (s.charAt(start) == ' ') start++;

    int end = s.length() - 1;
    while (s.charAt(end) == ' ') end--;

    int length = end - start + 1;
    char[] arr = new char[length];
    System.arraycopy(s.toCharArray(), start, arr, 0, length);
    return new String(arr);
  }
}
