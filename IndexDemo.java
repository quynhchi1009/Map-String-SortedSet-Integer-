package edu.hm.cs.bka.dev2.index;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Demo-Klasse zur Testindizierung.
 */
public class IndexDemo {

  /**
   * Demo-Programm zur Verwendung der Klasse {@link Index}.
   *
   * @param args werden ignoriert
   * @throws IOException        .
   * @throws URISyntaxException .
   */
  public static void main(String[] args) throws IOException, URISyntaxException {
    // Einlesen der Datei
    List<String> text = readTextAsList("faust.txt");

    // Aufbau des Index
    Index index = new Index();
    int wordCount = 0;
    for (String word : text) {
      index.addOccurrence(word, 1 + wordCount / 300);
      wordCount++;
    }

    Scanner in = new Scanner(System.in);
    while (true) {
      System.out.print("Wort suchen (q beendet)> ");
      String result = in.nextLine();
      if (result.equals("q")) {
        break;
      }
      System.out.println(index.getEntry(result));
    }
    in.close();
  }

  /**
   * Hilfsmethode zum Einlesen von Faust. Nicht weiter beachten!
   *
   * @param filename Dateiname
   * @return Liste der Wörter
   * @throws IOException        bei Dateilesefehlern
   * @throws URISyntaxException bei Fehlern im Dateipfad
   */
  private static List<String> readTextAsList(String filename)
      throws IOException, URISyntaxException {
    ClassLoader classLoader = IndexDemo.class.getClassLoader();
    Path file = Paths.get(classLoader.getResource("faust.txt").toURI());
    List<String> l = new ArrayList<>();
    try (Stream<String> lines = Files.lines(file, StandardCharsets.UTF_8)) {
      Stream<String> words = lines.map(line -> line.split("[^\\p{L}]"))
          .flatMap(Arrays::stream).filter(word -> word.length() > 0);

      words.forEachOrdered(l::add);
    }
    return l;
  }
}
