package com.itutry.datetimenew.other;

import java.time.LocalDate;
import java.time.Period;

/**
 * @author itutry
 * @create 2020-05-05_10:23
 */
public class PeriodTest {

  public static void main(String[] args) {
    //Period:用于计算两个“日期”间隔，以年、月、日衡量
    LocalDate localDate = LocalDate.now();
    LocalDate localDate1 = LocalDate.of(2028, 3, 18);

    final Period period = Period.between(localDate, localDate1);

    System.out.println(period);
    System.out.println(period.getYears());
    System.out.println(period.getMonths());
    System.out.println(period.getDays());

    Period period1 = period.withYears(2);
    System.out.println(period1);
  }
}
