package com.itutry.demo1;

public class SeasonTest {

  public static void main(String[] args) {
    Season autumn = Season.AUTUMN;
    System.out.println(autumn);
  }
}

class Season {
  private final String name;
  private final String desc;

  private Season(String name, String desc) {
    this.name = name;
    this.desc = desc;
  }

  public static final Season SPRING = new Season("春天", "春暖花开");
  public static final Season SUMMER = new Season("夏天", "夏日炎炎");
  public static final Season AUTUMN = new Season("秋天", "秋高气爽");
  public static final Season WINTER = new Season("冬天", "冰天雪地");

  public String getName() {
    return name;
  }

  public String getDesc() {
    return desc;
  }

  @Override
  public String toString() {
    return "Season{" +
        "name='" + name + '\'' +
        ", desc='" + desc + '\'' +
        '}';
  }
}
