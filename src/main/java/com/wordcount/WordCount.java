package com.wordcount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class WordCount {

  private ArrayList<String> split = new ArrayList<String>();
  private HashSet<String> unique = new HashSet<String>();
  private Map<String, Integer> uniqueCount = new HashMap<String, Integer>();
  public static void main(String[] args) {
    System.out.println("Hello World!");
  }

  public String readFile(String URI) {
    IReader reader = new WCFileReader();
    String fileContent = reader.read(URI);
    this.split(fileContent);
    return fileContent;
  }

  private Collection<String> split(String text) {
    this.split = new ArrayList<String>(Arrays.asList(text.split("\n")));
    return this.split;
  }

  public Collection<String> getSplit() {
    return this.split;
  }

  public Collection<String> getUnique() {
    this.unique = new HashSet<String>(this.split);
    return this.unique;
  }

  public Map<String, Integer> getUniqueCount() {
    this.uniqueCount = new HashMap<String, Integer>();
    for (String s : this.split) {
      if (this.uniqueCount.containsKey(s)) {
        this.uniqueCount.put(s, this.uniqueCount.get(s) + 1);
      } else {
        this.uniqueCount.put(s, 1);
      }
    }
    return this.uniqueCount;
  }
}
