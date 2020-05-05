package com.itutry.datetime.exer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 字符串"2020-09-08" 转换成 java.sql.Date
 *
 * @author itutry
 * @create 2020-05-04_19:05
 */
public class SimpleDateFormatExer1 {

  public static void main(String[] args) throws ParseException {
    String text = "2020-09-08";
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    final Date date = sdf.parse(text);
    System.out.println(date);

    final java.sql.Date date1 = new java.sql.Date(date.getTime());
    System.out.println(date1);
  }
}
