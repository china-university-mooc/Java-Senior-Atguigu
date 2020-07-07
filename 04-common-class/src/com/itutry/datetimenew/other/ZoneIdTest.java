package com.itutry.datetimenew.other;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Set;

/**
 * @author itutry
 * @create 2020-05-05_10:13
 */
public class ZoneIdTest {

  public static void main(String[] args) {
    // ZoneId: 时区信息
    // ZoneId的getAvailableZoneIds():获取所有的ZoneId
    final Set<String> zoneIds = ZoneId.getAvailableZoneIds();
    for (String s: zoneIds) {
      System.out.println(s);
    }

    // ZoneId的of():获取指定时区的时间
    final LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
    System.out.println(localDateTime);
  }
}
