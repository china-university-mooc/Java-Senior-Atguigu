package com.itutry.demo2;

import java.lang.Thread.State;
import java.util.Arrays;

public class SeasonTest {

  public static void main(String[] args) {
    Season autumn = Season.AUTUMN;
    System.out.println(autumn);
//    System.out.println(Season.class.getSuperclass());
    System.out.println(Arrays.toString(Season.values()));

    System.out.println(Arrays.toString(State.values()));

//    Season.valueOf("a");
    autumn.show();
  }
}

interface Info {
  void show();
}

enum Season implements Info {
  SPRING("春天", "春暖花开") {
    @Override
    public void show() {
      System.out.println("春天在哪里？");
    }
  },
  SUMMER("夏天", "夏日炎炎") {
    @Override
    public void show() {
      System.out.println("宁夏");
    }
  },
  AUTUMN("秋天", "秋高气爽") {
    @Override
    public void show() {
      System.out.println("秋天不回来");
    }
  },
  WINTER("冬天", "冰天雪地") {
    @Override
    public void show() {
      System.out.println("大约在冬天");
    }
  };

  private final String name;
  private final String desc;

  Season(String name, String desc) {
    this.name = name;
    this.desc = desc;
  }


  public String getName() {
    return name;
  }

  public String getDesc() {
    return desc;
  }

//  @Override
//  public void show() {
//    System.out.println("这是一个季节：" + name);
//  }
}
