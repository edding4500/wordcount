package com.wordcount;

import java.io.BufferedReader;
import java.io.Console;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;

public class WCFileReader implements IReader {

  public String read(String filename) {

    StringBuilder sb = new StringBuilder();
    BufferedReader br = null;
    try {
      br = new BufferedReader(
        new FileReader(filename)
      );
      String line = null;
      while ((line = br.readLine()) != null) {
        sb.append(line);
        sb.append("\n");
      }
      sb.deleteCharAt(sb.length() - 1);
      br.close();
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      System.out.println("File not found");
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return sb.toString();
  }
}
