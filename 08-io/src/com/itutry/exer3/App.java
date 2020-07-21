package com.itutry.exer3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class App {

  public static void main(String[] args) {
    App app = new App();
    byte key = 100;
//    app.encrypt("08-io/爱情与友情.jpg", "08-io/爱情与友情1.jpg", key);
//    app.encrypt("08-io/爱情与友情1.jpg", "08-io/爱情与友情2.jpg", key);

    app.encrypt("08-io/dbcp.txt", "08-io/dbcp1.txt", key);
    app.encrypt("08-io/dbcp1.txt", "08-io/dbcp2.txt", key);
  }

  public void encrypt(String srcPath, String destPath, byte key) {
    try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcPath));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destPath))) {

//      int data;
//      while((data = bis.read()) != -1) {
//        bos.write(data ^ key);
//      }

      byte[] buff = new byte[1024];
      int len;
      while((len = bis.read(buff)) != -1) {
        for (int i = 0; i < len; i++) {
          buff[i] = (byte) (buff[i] ^ i);
        }
        bos.write(buff, 0, len);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
