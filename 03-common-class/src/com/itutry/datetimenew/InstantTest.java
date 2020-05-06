package com.itutry.datetimenew;

import java.time.Instant;

/**
 * @author itutry
 * @create 2020-05-04_22:24
 */
public class InstantTest {

  public static void main(String[] args) {
    // now(): 获取当前的UTC时间戳
    final Instant instant = Instant.now();
    System.out.println(instant);

    // toEpochMilli(): 获取自1970年1月1日0时0分0秒(UTC)开始的毫秒数
    System.out.println(instant.toEpochMilli());

    // ofEpochMilli(): 指定毫秒数
    final Instant instant1 = Instant.ofEpochMilli(1588602688893L);
    System.out.println(instant1);
  }
}
