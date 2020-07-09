package com.itutry.demo1;

import java.util.Arrays;
import java.util.Comparator;
import org.junit.Test;

public class MyTest {

  @Test
  public void test1() {
    Goods[] goods = new Goods[5];
    goods[0] = new Goods("leno mouse", 34);
    goods[1] = new Goods("dell mouse", 43);
    goods[2] = new Goods("xiaomi mouse", 12);
    goods[3] = new Goods("huawei mouse", 65);
    goods[4] = new Goods("sanxing mouse", 43);

    Arrays.sort(goods);

    System.out.println(Arrays.toString(goods));
  }

  @Test
  public void test2() {
    String[] arr = {"AA", "BB", "KK", "MM", "GG", "JJ", "DD"};
    Arrays.sort(arr, new Comparator() {

      @Override
      public int compare(Object o1, Object o2) {
        if (o1 instanceof String && o2 instanceof String) {
          String s1 = (String) o1;
          String s2 = (String) o2;
          return s2.compareTo(s1);
        }
        throw new RuntimeException("传入的数据类型不一致");
      }
    });

    System.out.println(Arrays.toString(arr));
  }
}
