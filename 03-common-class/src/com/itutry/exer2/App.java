package com.itutry.exer2;

/**
 * 将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反
 * 转为”abfedcg”
 */
public class App {

  public static void main(String[] args) {
    String s1 = "abcdefg";
    System.out.println(reverse(s1, 2, 5));
  }

  public static String reverse1(String s, int start, int end) {
    if (s == null) {
      return null;
    }

    char[] chars = s.toCharArray();
    for (; start < end; start++, end--) {
      char temp = chars[start];
      chars[start] = chars[end];
      chars[end] = temp;
    }
    return new String(chars);
  }

  public static String reverse(String s, int start, int end) {
    if (s == null) {
      return null;
    }

    StringBuilder sb = new StringBuilder(s.length());
    sb.append(s, 0, start);
    for (int i = end; i >= start; i--) {
      sb.append(s.charAt(i));
    }
    sb.append(s, end + 1, s.length());
    return sb.toString();
  }
}
