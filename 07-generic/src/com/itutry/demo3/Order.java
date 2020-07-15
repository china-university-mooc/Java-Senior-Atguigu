package com.itutry.demo3;

import java.util.ArrayList;
import java.util.List;
import org.omg.CORBA.Object;

public class Order<T> {

  private String orderName;
  private int orderId;
  private T orderT;

  public Order() {
//    T[] arr = new T[10];
    T[] arr = (T[]) new Object[10];
  }

  public Order(String orderName, int orderId, T orderT) {
    this.orderName = orderName;
    this.orderId = orderId;
    this.orderT = orderT;
  }

  public T getOrderT() {
    return orderT;
  }

  public void setOrderT(T orderT) {
    this.orderT = orderT;
  }

  @Override
  public String toString() {
    return "Order{" +
        "orderName='" + orderName + '\'' +
        ", orderId=" + orderId +
        ", orderT=" + orderT +
        '}';
  }

  public static  <E> List<E> arrayToList(E[] arr) {
    ArrayList<E> list = new ArrayList<>();
    for (E e : arr) {
      list.add(e);
    }
    return list;
  }
}
