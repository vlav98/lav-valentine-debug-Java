package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {
  private static final String INPUT_FILE = "Project02Eclipse/resources/symptoms.txt";
  private static final String OUTPUT_FILE = "Project02Eclipse/resources/result.out";

  /**
   * @param args
   */
  public static void main(String[] args) {
    ISymptomReader reader = new ReadSymptomDataFromFile(INPUT_FILE);
    ISymptomWriter writer = new WriteSymptomDataToFile(OUTPUT_FILE);

    AnalyticsCounter counter = new AnalyticsCounter(reader, writer);

    List<String> symptoms = counter.getSymptoms();
    Map<String, Integer> countMap = counter.sortSymptoms(counter.countSymptoms(symptoms));
    counter.writeSymptoms(countMap);
  }
}
