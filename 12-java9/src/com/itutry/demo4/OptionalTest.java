package com.itutry.java.demo4;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import org.junit.Test;

public class OptionalTest {

  @Test
  public void test1() {
    List<String> list = new ArrayList<>(); list.add("Tom");
    list.add("Jerry");
    list.add("Tim");
    Optional<List<String>> optional = Optional.ofNullable(list);
    Stream<List<String>> stream = optional.stream();
    stream.flatMap(x -> x.stream()).forEach(System.out::println);
  }
}
