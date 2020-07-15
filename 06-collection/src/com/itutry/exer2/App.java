package com.itutry.exer2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class App {

  public static void main(String[] args) {
    List list = new ArrayList();

    list.add(Integer.valueOf(1));
    list.add(Integer.valueOf(2));
    list.add(Integer.valueOf(2));
    list.add(Integer.valueOf(4));
    list.add(Integer.valueOf(4));

    List list2 = duplicateList(list);

    System.out.println(list2);
  }

  private static List duplicateList(List list) {
    return new ArrayList(new HashSet(list));
  }
}
