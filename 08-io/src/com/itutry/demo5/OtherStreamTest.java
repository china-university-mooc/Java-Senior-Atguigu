package com.itutry.demo5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import org.junit.Test;

public class OtherStreamTest {

  public static void main(String[] args) throws IOException {
    new OtherStreamTest().test3();
  }

  @Test
  public void test1() throws IOException {
    InputStream in = System.in;
    PrintStream out = System.out;
    InputStreamReader isr = new InputStreamReader(in);
    OutputStreamWriter osw = new OutputStreamWriter(out);

    int data;
    StringBuilder sb = new StringBuilder();
    while ((data = isr.read()) != -1) {
      char c = (char) data;
      sb.append(c);

      if (c == '\n') {
        String str = sb.toString();
        if ("e\n".equals(str) || "exit\n".equals(str)) {
          break;
        }
        osw.write(str.toUpperCase().toCharArray());
        osw.flush();
        sb = new StringBuilder();
      }
    }

    osw.close();
    isr.close();
  }

  @Test
  public void test2() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    String line;
    while ((line = br.readLine()) != null) {
      if ("e".equalsIgnoreCase(line) || "exit".equalsIgnoreCase(line)) {
        System.out.println("程序结束");
        break;
      }

      bw.write(line.toUpperCase());
      bw.newLine();
      bw.flush();
    }

    bw.close();
    br.close();
  }

  @Test
  public void test3() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while (true) {
      System.out.println("请输入字符串(e或exit表示退出)：");

      String line = br.readLine();
      if ("e".equalsIgnoreCase(line) || "exit".equalsIgnoreCase(line)) {
        System.out.println("程序结束");
        break;
      }

      System.out.println(line.toUpperCase());
    }

    br.close();
  }

  @Test
  public void test4() throws FileNotFoundException {

    FileOutputStream fos = new FileOutputStream("text.txt");
    PrintStream ps = new PrintStream(fos, true);
    System.setOut(ps);

    for (int i = 0; i < 255; i++) {
      System.out.print((char) i);
      if (i % 50 == 0) {
        System.out.println();
      }
    }

    ps.close();
  }

  @Test
  public void test5() throws IOException {
    DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));

    dos.writeUTF("刘敏");
    dos.flush();
    dos.writeInt(18);
    dos.flush();
    dos.writeBoolean(false);

    dos.flush();
    dos.close();
  }

  @Test
  public void test6() throws IOException {
    DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"));

    System.out.println(dis.readUTF());
    System.out.println(dis.readInt());
    System.out.println(dis.readBoolean());

    dis.close();
  }
}
