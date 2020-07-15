package com.itutry.exer3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 请从键盘随机输入10个整数保存到List中，并按倒序、从大 到小的顺序显示出来
 */
public class App {

  public static void main(String[] args) {
    List list = new ArrayList();
    Scanner scanner = new Scanner(System.in);
    for (int i = 0; i < 10; i++) {
      int num = scanner.nextInt();
      list.add(num);
    }

    Collections.reverse(list);
    System.out.println(list);
    Collections.sort(list, new Comparator<Object>() {
      @Override
      public int compare(Object o1, Object o2) {
        if (o1 instanceof Integer && o2 instanceof Integer) {
          Integer i1 = (Integer) o1;
          Integer i2 = (Integer) o2;
          return i2.compareTo(i1);
        }

        throw new RuntimeException("输入的数据类型不一致");
      }
    });
    System.out.println(list);
  }
}
