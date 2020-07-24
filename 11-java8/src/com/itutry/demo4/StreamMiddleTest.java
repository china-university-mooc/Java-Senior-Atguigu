package com.itutry.demo4;

import com.itutry.demo3.Employee;
import com.itutry.demo3.EmployeeData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;
import org.junit.Test;

public class StreamFilterTest {

  @Test
  public void test1() {
    List<Employee> list = EmployeeData.getEmployees();
    Stream<Employee> stream = list.stream();

    stream.filter(e -> e.getSalary() > 7000).forEach(System.out::println);
    System.out.println();

    list.stream().limit(3).forEach(System.out::println);
    System.out.println();

    list.stream().skip(3).forEach(System.out::println);
    System.out.println();

    list.add(new Employee(1010, "刘强东", 40, 8000));
    list.add(new Employee(1010, "刘强东", 40, 8000));
    list.add(new Employee(1010, "刘强东", 40, 8000));
    list.add(new Employee(1010, "刘强东", 40, 8000));

    list.stream().distinct().forEach(System.out::println);
    System.out.println();
  }

  @Test
  public void test2() {
    List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
    list.stream().map(s -> s.toUpperCase()).forEach(System.out::println);
    System.out.println();

    EmployeeData.getEmployees().stream()
        .map(Employee::getName)
        .filter(n -> n.length() > 3)
        .forEach(System.out::println);
    System.out.println();

    Stream<Stream<Character>> streamStream = list.stream().map(this::fromStringToStream);
    streamStream.forEach(s -> {
      s.forEach(System.out::println);
    });
    System.out.println();

    Stream<Character> characterStream = list.stream().flatMap(this::fromStringToStream);
    characterStream.forEach(System.out::println);
  }

  @Test
  public void test3() {
    List<Integer> list = Arrays.asList(5, 2, 3, 1, 4);
    list.stream().sorted().forEach(System.out::println);

//    EmployeeData.getEmployees().stream()
//        .sorted((e1, e2) -> {
//          int compare = Integer.compare(e1.getAge(), e2.getAge());
//          if (compare != 0) {
//            return compare;
//          }
//          return Double.compare(e1.getSalary(), e2.getSalary());
//        })
//        .forEach(System.out::println);

    EmployeeData.getEmployees().stream()
        .sorted(Comparator.comparingInt(Employee::getAge).thenComparingDouble(Employee::getSalary))
        .forEach(System.out::println);
  }

  public Stream<Character> fromStringToStream(String s) {
    List<Character> list = new ArrayList<>();
    for (char c : s.toCharArray()) {
      list.add(c);
    }
    return list.stream();
  }
}
