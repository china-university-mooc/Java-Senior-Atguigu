package com.itutry.datetimenew;

import java.util.Date;

/**
 * @author itutry
 * @create 2020-05-04_20:51
 */
public class DateTest {

  public static void main(String[] args) {
    // 偏移性
//    final Date date = new Date(2020, 5, 4);
    final Date date = new Date(2020 - 1900, 5 - 1, 4);
    System.out.println(date);
  }
}
