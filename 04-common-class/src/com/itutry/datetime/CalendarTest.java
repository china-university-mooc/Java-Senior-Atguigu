package com.itutry.datetime;

import java.util.Calendar;
import java.util.Date;

/**
 * @author itutry
 * @create 2020-05-04_18:35
 */
public class CalendarTest {

  public static void main(String[] args) {
    final Calendar calendar = Calendar.getInstance();
    System.out.println(calendar.getTime());

    System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
    System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
    System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
    System.out.println(calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));

    calendar.set(Calendar.MONTH, 0);
    System.out.println(calendar.getTime());

    calendar.set(Calendar.DAY_OF_WEEK, 1);
    System.out.println(calendar.getTime());

    calendar.set(Calendar.DAY_OF_MONTH, 6);
    System.out.println(calendar.getTime());

    calendar.add(Calendar.DAY_OF_MONTH, 3);
    System.out.println(calendar.getTime());

    calendar.add(Calendar.DAY_OF_MONTH, -3);
    System.out.println(calendar.getTime());

    calendar.setTime(new Date());
    System.out.println(calendar.getTime());
  }
}
