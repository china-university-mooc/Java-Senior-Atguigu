package com.itutry.demo1;

public class Goods implements Comparable {

  private String name;
  private double price;

  public Goods() {
  }

  public Goods(String name, double price) {
    this.name = name;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Goods{" +
        "name='" + name + '\'' +
        ", price=" + price +
        '}';
  }

  @Override
  public int compareTo(Object o) {
    System.out.println("******");
    if (o instanceof Goods) {
      Goods g = (Goods) o;
      if (this.price > g.price) {
        return 1;
      } else if (this.price < g.price) {
        return -1;
      } else {
        return this.name.compareTo(g.name);
      }

//      return Double.compare(this.price, g.price);
    }

    throw new RuntimeException("传入的数据类型不一致");
  }
}
