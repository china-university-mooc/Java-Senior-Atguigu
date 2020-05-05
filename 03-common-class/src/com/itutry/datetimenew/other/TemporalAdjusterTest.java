package com.itutry.datetimenew.other;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * @author itutry
 * @create 2020-05-05_10:25
 */
public class TemporalAdjusterTest {

  public static void main(String[] args) {
    // TemporalAdjuster:时间校正器
    // 获取当前日期的下一个周日是哪天?
    final TemporalAdjuster temporalAdjuster = TemporalAdjusters.next(DayOfWeek.SUNDAY);
    final LocalDateTime localDateTime = LocalDateTime.now().with(temporalAdjuster);
    System.out.println(localDateTime);

    // 获取下一个工作日是哪天?
    final LocalDate localDate = LocalDate.now().with(new TemporalAdjuster() {
      @Override
      public Temporal adjustInto(Temporal temporal) {
        final LocalDate date = (LocalDate) temporal;
        if (date.getDayOfWeek() == DayOfWeek.FRIDAY) {
          return date.plusDays(3);
        } else if (date.getDayOfWeek() == DayOfWeek.SATURDAY) {
          return date.plusDays(2);
        } else {
          return date.plusDays(1);
        }
      }
    });
    System.out.println("下一个工作日是:" + localDate);
  }
}
