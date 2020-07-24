package com.itutry.demo1;

import org.junit.Test;

public class StringTest {

  @Test
  public void test1() {

    System.out.println("  ".isBlank());
    var s = "   Hello    ";
    System.out.println("===" + s.strip() + "===");
    System.out.println("===" + s.stripLeading() + "===");
    System.out.println("===" + s.stripTrailing() + "===");

    System.out.println("Hi".repeat(3));

    System.out.println("abc\ndefg".lines().count());
  }
}
