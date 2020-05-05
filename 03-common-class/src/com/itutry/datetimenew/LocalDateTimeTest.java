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
//    test1();
//    test2();
    test3();
  }

  /**
   * 实例化
   */
  private static void test1() {
    // now(): 获取当前日期/时间
    final LocalDate date = LocalDate.now();
    final LocalTime time = LocalTime.now();
    final LocalDateTime dateTime = LocalDateTime.now();
    System.out.println(date);
    System.out.println(time);
    System.out.println(dateTime);

    // of(): 指定年、月、日、时、分、秒。没有偏移
    final LocalDateTime dateTime1 = LocalDateTime.of(2020, 10, 1, 12, 12, 12);
    System.out.println(dateTime1);
  }

  /**
   * 访问
   */
  private static void test2() {
    final LocalDateTime now = LocalDateTime.now();
    System.out.println(now);

    System.out.println(now.getDayOfMonth());
    System.out.println(now.getDayOfWeek());

    System.out.println(now.getMonth());
    System.out.println(now.getMonthValue());

    System.out.println(now.getMinute());
  }

  /**
   * 修改
   */
  private static void test3() {
    final LocalDateTime now = LocalDateTime.now();

    // 体现不可变性
    final LocalDateTime dateTime = now.withDayOfMonth(10);
    System.out.println(now);
    System.out.println(dateTime);

    final LocalDateTime dateTime1 = now.plusWeeks(1);
    System.out.println(dateTime1);

    final LocalDateTime dateTime2 = now.minusYears(1);
    System.out.println(dateTime2);
  }
}
