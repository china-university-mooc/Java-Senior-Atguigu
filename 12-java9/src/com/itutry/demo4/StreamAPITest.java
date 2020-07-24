package com.itutry.java.demo4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.Test;

public class StreamAPITest {

  @Test
  public void test1() {
    List<Integer> list = Arrays.asList(23, 43, 45, 55, 61, 54, 32, 2, 45, 87, 7);

    list.stream().takeWhile(x -> x < 60).forEach(System.out::println);

    System.out.println();
    list.stream().dropWhile(x -> x < 60).forEach(System.out::println);
  }

  @Test
  public void test2() {
    Stream<Integer> stream = Stream.of(1, 2, 3, null);
    stream.forEach(System.out::println);

//    Stream<Object> stream1 = Stream.of(null);
    Stream<Object> stream1 = Stream.ofNullable(null);
    stream1.forEach(System.out::println);
  }

  @Test
  public void test3() {
    Stream<Integer> stream = Stream.iterate(0, x -> x < 7, x -> x + 2);
    stream.forEach(System.out::println);
  }
}
