package com.itutry.exer1;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;
import org.junit.Test;

public class EmployeeTest {

  @Test
  public void test1() {
    TreeSet set = new TreeSet();

    Employee e1 = new Employee("liudehua", 55, new MyDate(1965, 5, 4));
    Employee e2 = new Employee("zhangxueyou", 43, new MyDate(1987, 5, 4));
    Employee e3 = new Employee("guofucheng", 44, new MyDate(1987, 5, 9));
    Employee e4 = new Employee("liming", 51, new MyDate(1954, 8, 12));
    Employee e5 = new Employee("liangchaowei", 21, new MyDate(1978, 12, 4));

    set.add(e1);
    set.add(e2);
    set.add(e3);
    set.add(e4);
    set.add(e5);

    Iterator it = set.iterator();
    while(it.hasNext()) {
      System.out.println(it.next());
    }
  }

  @Test
  public void test2() {
    TreeSet set = new TreeSet(new Comparator() {
      @Override
      public int compare(Object o1, Object o2) {
        if (o1 instanceof Employee && o2 instanceof Employee) {
          Employee e1 = (Employee) o1;
          Employee e2 = (Employee) o2;

          MyDate b1 = e1.getBirthday();
          MyDate b2 = e2.getBirthday();
//          int minusYear = b1.getYear() - b2.getYear();
//          if (minusYear != 0) {
//            return minusYear;
//          }
//
//          int minusMonth = b1.getMonth() - b2.getMonth();
//          if (minusMonth != 0) {
//            return minusMonth;
//          }
//
//          return b1.getDay() - b2.getDay();
          return b1.compareTo(b2);
        } else {
          throw new RuntimeException("传入的数据类型不一致");
        }
      }
    });

    Employee e1 = new Employee("liudehua", 55, new MyDate(1965, 5, 4));
    Employee e2 = new Employee("zhangxueyou", 43, new MyDate(1987, 5, 4));
    Employee e3 = new Employee("guofucheng", 44, new MyDate(1987, 5, 9));
    Employee e4 = new Employee("liming", 51, new MyDate(1954, 8, 12));
    Employee e5 = new Employee("liangchaowei", 21, new MyDate(1978, 12, 4));

    set.add(e1);
    set.add(e2);
    set.add(e3);
    set.add(e4);
    set.add(e5);

    Iterator it = set.iterator();
    while(it.hasNext()) {
      System.out.println(it.next());
    }
  }
}
