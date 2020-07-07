package com.itutry.datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author itutry
 * @create 2020-05-04_18:29
 */
public class SimpleDateFormatTest {

  public static void main(String[] args) throws ParseException {
    // 默认本地化格式
    final SimpleDateFormat sdf = new SimpleDateFormat();
    final String text = sdf.format(new Date());
    System.out.println(text);

    final Date date2 = sdf.parse("21-5-4 下午6:31");
    System.out.println(date2);

    // 自定义格式
    final SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    System.out.println(sdf2.format(new Date()));
    System.out.println(sdf2.parse("2021-05-04 06:33:49"));
  }
}
