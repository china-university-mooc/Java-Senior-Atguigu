package com.itutry.java.demo4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class CollectionTest {

  @Test
  public void test1() {
    List<String> namesList = new ArrayList<>();
    namesList.add("Joe");
    namesList.add("Bob");
    namesList.add("Bill");

    namesList = Collections.unmodifiableList(namesList);
    namesList.add("Tom");
    System.out.println(namesList);
  }

  @Test
  public void test2() {
    List<Integer> list = Arrays.asList(1, 2, 3);
//    list.add(6);

    List<Integer> list1 = List.of(1, 2, 3);
//    list1.add(3);
    System.out.println(list1);
//    Set<Integer> set = Set.of(1, 2);
//    System.out.println(set);
//    Map<String, Integer> map = Map.of("key", 1);
//    System.out.println(map);

    Map<String, Integer> map = Map.ofEntries(Map.entry("key", 1));
    System.out.println(map);
  }
}
