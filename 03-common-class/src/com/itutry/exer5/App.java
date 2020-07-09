package com.itutry.exer5;

/**
 * 对字符串中字符进行自然顺序排序。
 * 提示:
 * 1)字符串变成字符数组。 2)对数组排序，选择，冒泡，Arrays.sort(); 3)将排序后的数组变成字符串。
 */
public class App {

  public static void main(String[] args) {
    System.out.println(sort("dbjdosknsdknasdnkld"));
  }

  public static String sort(String s) {
    if (s == null) {
      return null;
    }

    char[] chars = s.toCharArray();

    for (int i = 0; i < s.length() - 1; i++) {
      for (int j = 1; j < s.length() - i; j++) {
        if (chars[j - 1] > chars[j]) {
          char temp = chars[j - 1];
          chars[j- 1] = chars[j];
          chars[j] = temp;
        }
      }
    }

//    Arrays.sort(chars);

    return new String(chars);
  }
}
