package com.itutry.exer4;

import java.util.Arrays;

/**
 * 获取两个字符串中最大相同子串。比如:
 * str1 = "abcwerthelloyuiodef“;str2 = "cvhellobnm" 提示:将短的那个串进行长度依次递减的子串与较长的串比较。
 */
public class App {

  public static void main(String[] args) {
    String[] result = getMaxSubstring("abcwerthelloyuiodef", "cvhellobnmiodef");
    System.out.println(Arrays.toString(result));
  }

  public static String getMaxSubstring1(String s1, String s2) {
    String s = s1.length() <= s2.length() ? s1 : s2;
    String l = s1.length() > s2.length() ? s1 : s2;

    String maxSub = "";
    for (int i = 0; i < s.length(); i++) {
      for (int j = i; j < s.length(); j++) {
        String sub = s.substring(i, j + 1);
        if (l.contains(sub) && sub.length() > maxSub.length()) {
          maxSub = sub;
        }
      }
    }

    return maxSub;
  }

  public static String getMaxSubstring2(String s1, String s2) {
    if (s1 == null || s2 == null) {
      return null;
    }

    String s = s1.length() <= s2.length() ? s1 : s2;
    String l = s1.length() > s2.length() ? s1 : s2;

    for (int i = 0; i < s.length(); i++) {
      for (int x = 0, y = s.length() - i; y < s.length(); x++, y++) {
        String sub = s.substring(x, y);
        if (l.contains(sub)) {
          return sub;
        }
      }
    }

    return null;
  }

  public static String[] getMaxSubstring(String s1, String s2) {
    if (s1 == null || s2 == null) {
      return null;
    }

    String s = s1.length() <= s2.length() ? s1 : s2;
    String l = s1.length() > s2.length() ? s1 : s2;

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      for (int x = 0, y = s.length() - i; y <= s.length(); x++, y++) {
        String sub = s.substring(x, y);
        if (l.contains(sub)) {
          sb.append(",").append(sub);
        }
      }
      if (sb.length() != 0) {
        return sb.toString().substring(1).split(",");
      }
    }

    return new String[0];
  }
}
