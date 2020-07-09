package com.itutry.test;

import java.math.BigDecimal;
import java.math.BigInteger;
import org.junit.Test;

public class BigDecimalTest {

  @Test
  public void test1() {

    BigInteger bi = new BigInteger("12333241123");
    BigDecimal bd = new BigDecimal("12435.351");
    BigDecimal bd2 = new BigDecimal("11");

    System.out.println(bi);
//    System.out.println(bd.divide(bd2));
    System.out.println(12435.351 / 11);
    System.out.println(bd.divide(bd2, BigDecimal.ROUND_HALF_UP));
    System.out.println(bd.divide(bd2, 115, BigDecimal.ROUND_HALF_UP));
  }
}
