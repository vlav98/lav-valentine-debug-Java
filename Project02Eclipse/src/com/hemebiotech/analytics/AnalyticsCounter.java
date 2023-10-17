package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	private ISymptomReader reader;
	private ISymptomWriter writer;

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	/**
	 * Get every symptom by reading a file
	 * 
	 * @return all symptoms as a List of strings
	 */
	public List<String> getSymptoms() {
		return reader.getSymptoms();
	}

	/**
	 * Count every symptom occurence with a list of symptoms
	 * 
	 * @param symptoms
	 * @return a map of symptoms and their count
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> symptomCounts = new HashMap<>();

		for (String symptom : symptoms) {
			symptomCounts.put(symptom, symptomCounts.getOrDefault(symptom, 0) + 1);
		}

		return symptomCounts;
	}

	/**
	 * Sort every symptom in the Map provided
	 * 
	 * @param symptoms
	 * @return a map of every symptom sorted by name
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		TreeMap<String, Integer> sortedSymptoms = new TreeMap<String, Integer>(symptoms);

		return sortedSymptoms;
	}

	/**
	 * Write the symptom and their count in a file
	 * 
	 * @param symptoms
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}
}
