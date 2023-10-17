package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {
  /**
   * @param args
   */
  public static void main(String[] args) {
    ISymptomReader reader = new ReadSymptomDataFromFile("./Project02Eclipse/resources/symptoms.txt");
    ISymptomWriter writer = new WriteSymptomDataToFile("./Project02Eclipse/resources/result.out");

    AnalyticsCounter counter = new AnalyticsCounter(reader, writer);

    List<String> symptoms = counter.getSymptoms();
    Map<String, Integer> countMap = counter.sortSymptoms(counter.countSymptoms(symptoms));
    counter.writeSymptoms(countMap);
  }
}
