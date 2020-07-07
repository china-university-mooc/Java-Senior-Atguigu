package com.itutry.datetimenew;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 * @author itutry
 * @create 2020-05-04_22:40
 */
public class DateTimeFormatterTest {

  public static void main(String[] args) {
    // 方式一：预定义的标准格式
    final DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
    final LocalDateTime now = LocalDateTime.now();
    final String str = formatter.format(now);
    System.out.println(str);

    final TemporalAccessor parse = formatter.parse("2021-05-04T22:43:53.292");
    System.out.println(parse);

    final LocalDateTime parse1 = formatter.parse("2021-05-04T22:43:53.292", LocalDateTime::from);
    System.out.println(parse1);

    // 方式二：本地化格式
    final DateTimeFormatter formatter1 = DateTimeFormatter
        .ofLocalizedDateTime(FormatStyle.SHORT);
    System.out.println(formatter1.format(now));

    // 方式三：自定义格式
    final DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    System.out.println(formatter2.format(now));
  }
}
