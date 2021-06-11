package edu.hm.cs.bka.dev2.index;

import java.util.*;

/**
 * Klasse zum Aufbau eines Textindex, d.h. zur Speicherung der Information, auf welchen Seiten eines
 * Buches ein Wort vorkommt.
 *
 * @author katz.bastian
 */
public class Index {
  Map<String, SortedSet<Integer>> vorkommnis = new HashMap<>();

  /**
   * Fügt ein Vorkommnis zum Index hinzu, d.h. ergänzt den Eintrag zu einem Wort um eine
   * Seitenzahl.
   *
   * @param word Wort
   * @param page Seitenzahl
   */
  public void addOccurrence(final String word, final int page) {
    // TODO: Implementierung ergänzen
    SortedSet<Integer> pages = new TreeSet<>();
    pages.add(page);
    if (!vorkommnis.containsKey(word)) {
      vorkommnis.putIfAbsent(word, pages);
    } else {
      SortedSet<Integer> newpages = vorkommnis.get(word);
      vorkommnis.remove(word);
      newpages.add(page);
      vorkommnis.put(word, newpages);
    }
  }

  /**
   * Liefert einen Eintrag von der Form "Wort: 1, 3, 7, 8".
   *
   * @param word Wort
   * @return Textueller Eintrag aus Wort und den Vorkommnissen
   */
  public String getEntry(String word) {
    // TODO: Implementierung ergänzen
    ArrayList<Integer> result = new ArrayList<>();
    for (String x : vorkommnis.keySet()) {
      if (x.equals(word)) {
        SortedSet<Integer> t = vorkommnis.get(x);
        result.addAll(t);
      }
    }
    if (result.isEmpty()) {
      return word + ": ---";
    } else {
      String formattedString = result.toString()
          .replace("[", "")  //remove the right bracket
          .replace("]", "")  //remove the left bracket
          .trim();           //remove trailing spaces from partially initialized arrays
      return word + ": " + formattedString;
    }
  }
}
