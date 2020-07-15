package com.itutry.exer1;

public class MyDate implements Comparable{

  private int year;
  private int month;
  private int day;

  public MyDate() {
  }

  public MyDate(int year, int month, int day) {
    this.year = year;
    this.month = month;
    this.day = day;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public int getMonth() {
    return month;
  }

  public void setMonth(int month) {
    this.month = month;
  }

  public int getDay() {
    return day;
  }

  public void setDay(int day) {
    this.day = day;
  }

  @Override
  public String toString() {
    return "MyDate{" +
        "year=" + year +
        ", month=" + month +
        ", day=" + day +
        '}';
  }

  @Override
  public int compareTo(Object o) {
    if (o instanceof MyDate) {
      MyDate d = (MyDate) o;

      int minusYear = this.year - d.year;
      if (minusYear != 0) {
        return minusYear;
      }

      int minusMonth = this.month - d.month;
      if (minusMonth != 0) {
        return minusMonth;
      }

      return this.day - d.day;
    } else {
      throw new RuntimeException("传入的数据不一致");
    }
  }
}
