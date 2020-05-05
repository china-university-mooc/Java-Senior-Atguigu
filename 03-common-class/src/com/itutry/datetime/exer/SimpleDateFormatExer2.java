package com.itutry.datetime.exer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 渔夫从1990-01-01开始"三天打渔两天晒网"，到xxxx-xx-xx是在打渔还是晒网
 *
 * @author itutry
 * @create 2020-05-04_19:09
 */
public class SimpleDateFormatExer2 {

  public static void main(String[] args) throws ParseException {
    final String beginText = "1990-01-01";
    System.out.println("请输入现在的日期(格式：yyyy-MM-dd): ");
    final Scanner scanner = new Scanner(System.in);
    final String endText = scanner.next();

    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    final Date begin = sdf.parse(beginText);
    final Date end = sdf.parse(endText);

    long totalDays = (end.getTime() - begin.getTime()) / (1000 * 60 * 60 * 24) + 1;
    if (totalDays % 5 == 4 || totalDays % 5 == 0) {
      System.out.println("在晒网");
    } else {
      System.out.println("在打渔");
    }
  }
}
