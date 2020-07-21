package com.itutry.demo4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import org.junit.Test;

public class InputStreamReaderTest {

  @Test
  public void test1() throws IOException {
    FileInputStream fis = new FileInputStream("dbcp.txt");
    FileOutputStream fos = new FileOutputStream("dbcp_gbk.txt");

    try (
//        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        InputStreamReader isr = new InputStreamReader(fis);
        OutputStreamWriter osw = new OutputStreamWriter(fos, "GBK")) {
      char[] buff = new char[20];
      int len;
      while ((len = isr.read(buff)) != -1) {
//        System.out.print(new String(buff, 0, len));
        osw.write(buff, 0, len);
      }
    }

  }

  @Test
  public void test2() {
    OutputStreamWriter osw = null;
    try {
      osw = new OutputStreamWriter(new FileOutputStream("1.txt"),
          "UTF-8");

      osw.write("尚");
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (osw != null) {
        try {
          osw.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
