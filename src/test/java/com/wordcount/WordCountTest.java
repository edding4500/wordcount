package com.wordcount;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

public class WordCountTest {
  
  @Test
  public void testWordCountConstructor() {
    WordCount wc = new WordCount();
    assertNotNull(wc);
  }

  @Test
  public void testWordCountReadFile() {
    WordCount wc = new WordCount();
    String result = wc.readFile("./src/test/java/com/wordcount/testUnique.txt");
    String expected = "Mainz\nHamburg\nReutlingen\nStuttgart";
    assertEquals(expected, result);
  }

  /**
   * Test of getSplit method, of class WordCount.
   */
  @Test
  public void testWordCountSplit() {
    WordCount wc = new WordCount();
    wc.readFile("./src/test/java/com/wordcount/testUnique.txt");
    // init an arraylist with {"Mainz", "Hamburg", "Reutlingen", "Stuttgart"}
    Collection<String> expected = Arrays.asList("Mainz", "Hamburg", "Reutlingen", "Stuttgart");
    Collection<String> result = wc.getSplit();
    assertThat(result, is(expected));
  }

  @Test
  public void testWordCountGetUniqueWithUniques() {
    WordCount wc = new WordCount();
    wc.readFile("./src/test/java/com/wordcount/testUnique.txt");
    Collection<String> expected = Arrays.asList("Mainz", "Hamburg", "Reutlingen", "Stuttgart");
    Collection<String> result = wc.getUnique();
    for (String s : expected) {
      assertThat(result, hasItem(s));
    }
    assertEquals(expected.size(), result.size());

    wc.readFile("./src/test/java/com/wordcount/testDuplicate.txt");
    result = wc.getUnique();
    for (String s : expected) {
      assertThat(result, hasItem(s));
    }
    assertEquals(expected.size(), result.size());
  }

  @Test
  public void testWordCountGetUniqueWithDuplicates() {
    WordCount wc = new WordCount();
    Collection<String> expected = Arrays.asList("Mainz", "Hamburg", "Reutlingen", "Stuttgart");
    wc.readFile("./src/test/java/com/wordcount/testDuplicate.txt");
    Collection<String> result = wc.getUnique();
    for (String s : expected) {
      assertThat(result, hasItem(s));
    }
    assertEquals(expected.size(), result.size());
  }

  @Test
  public void testWordCountGetUniqueCountWithUniques() {
    WordCount wc = new WordCount();
    wc.readFile("./src/test/java/com/wordcount/testUnique.txt");
    Map<String, Integer> counts = wc.getUniqueCount();
    assertEquals(4, counts.size());
    assertEquals(1, counts.get("Mainz").intValue());
    assertEquals(1, counts.get("Hamburg").intValue());
    assertEquals(1, counts.get("Reutlingen").intValue());
    assertEquals(1, counts.get("Stuttgart").intValue());
  }

  @Test
  public void testWordCountGetUniqueCountWithDuplicates() {
    WordCount wc = new WordCount();
    wc.readFile("./src/test/java/com/wordcount/testDuplicate.txt");
    Map<String, Integer> counts = wc.getUniqueCount();
    assertEquals(4, counts.size());
    assertEquals(1, counts.get("Mainz").intValue());
    assertEquals(2, counts.get("Hamburg").intValue());
    assertEquals(1, counts.get("Reutlingen").intValue());
    assertEquals(1, counts.get("Stuttgart").intValue());
  }
}
