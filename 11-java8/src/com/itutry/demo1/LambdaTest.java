package com.itutry.demo1;

import java.util.Comparator;
import org.junit.Test;

/**
 * Lambda表达式使用举例
 */
public class LambdaTest {

  @Test
  public void test1() {
    Runnable r = new Runnable() {
      @Override
      public void run() {
        System.out.println("我爱北京天安门");
      }
    };
    r.run();

    System.out.println("**********************");

    Runnable r1 = () -> System.out.println("我爱北京故宫");
    r1.run();
  }

  @Test
  public void test2() {
    Comparator<Integer> com1 = new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
      }
    };

    int compare1 = com1.compare(12, 21);
    System.out.println(compare1);

    System.out.println("******************************");

    Comparator<Integer> com2 = (o1, o2) -> o1.compareTo(o2);
    int compare2 = com2.compare(32, 21);
    System.out.println(compare2);

    System.out.println("******************************");

    Comparator<Integer> com3 = Integer::compare;
    int compare3 = com2.compare(32, 21);
    System.out.println(compare3);
  }


}
