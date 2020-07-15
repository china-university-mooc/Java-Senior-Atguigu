package com.itutry.demo3;

import java.util.List;
import org.junit.Test;

public class OrderTest {

  @Test
  public void test1() {
    Order<String> order = new Order<>("AA", 1001, "order:AA");
    order.setOrderT("AA:hello");
    System.out.println(order);
  }

  @Test
  public void test2() {
    SubOrder subOrder = new SubOrder();
    subOrder.setOrderT(1122);

    SubOrder2<String> subOrder2 = new SubOrder2<>();
    subOrder2.setOrderT("oder2...");
  }

  @Test
  public void test3() {
    Order<String> order = new Order<>();
    Integer[] arr = {1, 2, 3, 4};
    List<Integer> integers = order.arrayToList(arr);
    System.out.println(integers);
  }
}
