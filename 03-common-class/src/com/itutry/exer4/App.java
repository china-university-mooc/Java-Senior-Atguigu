package com.itutry.exer4;

/**
 * 获取两个字符串中最大相同子串。比如:
 * str1 = "abcwerthelloyuiodef“;str2 = "cvhellobnm" 提示:将短的那个串进行长度依次递减的子串与较长的串比较。
 */
public class App {

  public static void main(String[] args) {
    System.out.println(getMaxSubstring("abcwerthelloyuiodef", "cvhellobnm"));
  }

  public static String getMaxSubstring(String s1, String s2) {
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
}
