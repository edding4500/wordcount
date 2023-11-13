package com.wordcount;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FileReaderTest {
  @Test
  public void testRead() {
    WCFileReader reader = new WCFileReader();
    String result = reader.read("./src/test/java/com/wordcount/testUnique.txt");
    String expected = "Mainz\nHamburg\nReutlingen\nStuttgart";
    assertEquals(expected, result);
  }
}
