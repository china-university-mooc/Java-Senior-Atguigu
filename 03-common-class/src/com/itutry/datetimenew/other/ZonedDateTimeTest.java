package com.itutry.datetimenew.other;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author itutry
 * @create 2020-05-05_10:19
 */
public class ZonedDateTimeTest {

  public static void main(String[] args) {
    //ZonedDateTime:带时区的日期时间
    // ZonedDateTime的now():获取本时区的ZonedDateTime对象
    final ZonedDateTime zonedDateTime = ZonedDateTime.now();
    System.out.println(zonedDateTime);

    // ZonedDateTime的now(ZoneId id):获取指定时区的ZonedDateTime对象
    final ZonedDateTime zonedDateTime1 = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
    System.out.println(zonedDateTime1);
  }
}
