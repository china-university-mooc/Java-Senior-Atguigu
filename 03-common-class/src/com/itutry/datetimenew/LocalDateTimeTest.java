package com.itutry.datetimenew;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author itutry
 * @create 2020-05-04_21:46
 */
public class LocalDateTimeTest {

  public static void main(String[] args) {
  }

  /**
   * 实例化
   */
  private static void test1() {
    // 方式一：now(): 获取当前日期/时间
    final LocalDateTime localDateTime = LocalDateTime.now();
    final LocalDate localDate = LocalDate.now();
    final LocalTime localTime = LocalTime.now();
    System.out.println(localDateTime);
    System.out.println(localDate);
    System.out.println(localTime);

    // 方式二：of(): 指定年、月、日、时、分、秒。没有偏移
    final LocalDateTime localDateTime1 = LocalDateTime.of(2020, 10, 1, 10, 10, 10);
    System.out.println(localDateTime1);
  }

  /**
   * 访问
   */
  private static void test2() {
    final LocalDateTime now = LocalDateTime.now();
    System.out.println(now);

    // 获取本月第几天
    System.out.println(now.getDayOfMonth());
    // 获取星期枚举值
    System.out.println(now.getDayOfWeek());

    // 获取月份枚举值
    System.out.println(now.getMonth());
    // 获取第几月
    System.out.println(now.getMonthValue());

    // 获取第几秒
    System.out.println(now.getMinute());
  }

  /**
   * 修改
   */
  private static void test3() {
    final LocalDateTime now = LocalDateTime.now();

    // 体现不可变性
    // 当月的天数改为10
    final LocalDateTime dateTime = now.withDayOfMonth(10);
    System.out.println(now);
    System.out.println(dateTime);

    // 增加一周
    final LocalDateTime dateTime1 = now.plusWeeks(1);
    System.out.println(dateTime1);

    // 减少一年
    final LocalDateTime dateTime2 = now.minusYears(1);
    System.out.println(dateTime2);
  }
}
