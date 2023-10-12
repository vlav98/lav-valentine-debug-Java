package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AnalyticsCounter {
	private ISymptomReader reader;
	private ISymptomWriter writer;

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	public List<String> getSymptoms() {
		return reader.GetSymptoms();
	}

	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> symptomCounts = new HashMap<>();

		for (String symptom : symptoms) {
			symptomCounts.put(symptom, symptomCounts.getOrDefault(symptom, 0) + 1);
		}

		return symptomCounts;
	}

	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		List<Map.Entry<String, Integer>> entryList = new ArrayList<>(symptoms.entrySet());
		Collections.sort(entryList, (entry1, entry2) -> entry1.getKey().compareTo(entry2.getKey()));
		Map<String, Integer> sortedSymptoms = new LinkedHashMap<>();

		for (Map.Entry<String, Integer> entry : entryList) {
			sortedSymptoms.put(entry.getKey(), entry.getValue());
		}

		return sortedSymptoms;
	}

	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.WriteSymptoms(symptoms);
	}

	public static void main(String args[]) throws Exception {
	}
}
