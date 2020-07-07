package com.itutry.datetimenew.other;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author itutry
 * @create 2020-05-05_10:19
 */
public class DurationTest {

  public static void main(String[] args) {
    //Duration:用于计算两个“时间”间隔，以秒和纳秒为基准
    final LocalTime localTime = LocalTime.now();
    final LocalTime localTime1 = LocalTime.of(15, 30, 30);

    //between():静态方法，返回Duration对象，表示两个时间的间隔
    final Duration duration = Duration.between(localTime, localTime1);
    System.out.println(duration);

    LocalDateTime localDateTime = LocalDateTime.of(2016, 6, 12, 15, 23, 32);
    LocalDateTime localDateTime1 = LocalDateTime.of(2017, 6, 12, 15, 23, 32);
    Duration duration1 = Duration.between(localDateTime, localDateTime1);
    System.out.println(duration1.toDays());
  }
}
