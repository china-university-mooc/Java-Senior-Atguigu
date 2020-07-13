package com.itutry.demo3;

import java.util.ArrayList;
import java.util.Date;

public class App {

  public static void main(String[] args) {
    @SuppressWarnings("unused")
    int num = 10;

    @SuppressWarnings({"rawtypes", "unused"})
    ArrayList list = new ArrayList();

    new Date(2020, 4, 3);
  }
}
