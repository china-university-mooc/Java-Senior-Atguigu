package com.itutry.exer4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class App {

  public static void main(String[] args) {
    HashMap<Character, Integer> counterMap;
    counterMap = new HashMap<>();
    try (BufferedReader br = new BufferedReader(new FileReader("08-io/dbcp.txt"))) {
      char[] buff = new char[1024];
      int len;
      while ((len = br.read(buff)) != -1) {
        for (int i = 0; i < len; i++) {
          char c = buff[i];
          if (c != '\n' && c != '\0' && c != ' ') {
            Integer num = counterMap.computeIfAbsent(c, k -> 0);
            counterMap.put(c, num + 1);
          }
        }
      }

      List<Entry<Character, Integer>> entries = new ArrayList<>(counterMap.entrySet());
      entries.sort(Entry.comparingByValue(Comparator.reverseOrder()));

      try (BufferedWriter bw = new BufferedWriter(new FileWriter("08-io/charCounter.txt"))) {
        for(Entry<Character, Integer> e : entries) {
          char key = e.getKey();
          switch (key) {
            case ' ':
              bw.write("空格=" + e.getValue());
              break;
            case '\t':
              bw.write("制表符=" + e.getValue());
              break;
            case '\n':
              bw.write("换行=" + e.getValue());
              break;
            case '\r':
              bw.write("回车=" + e.getValue());
              break;
            default:
              bw.write(e.getKey() + "=" + e.getValue());
          }
          bw.newLine();
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
