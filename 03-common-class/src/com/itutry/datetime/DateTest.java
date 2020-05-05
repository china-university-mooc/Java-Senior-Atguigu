package com.itutry.datetime;

import java.util.Date;

/**
 * @author itutry
 * @create 2020-05-04_18:17
 */
public class DateTest {

  public static void main(String[] args) {
    final Date date = new Date();
    System.out.println(date.toString());
    System.out.println(date.getTime());
    System.out.println(new Date(1588587681516L));

    final java.sql.Date date1 = new java.sql.Date(1588587681516L);
    System.out.println(date1);

    // sql.Date -> util.Date
    Date date2 = date1;
    System.out.println(date2);

    // util.Date -> sql.Date
    final Date date3 = new Date();
    final java.sql.Date date4 = new java.sql.Date(date3.getTime());
    System.out.println(date4);
  }
}
