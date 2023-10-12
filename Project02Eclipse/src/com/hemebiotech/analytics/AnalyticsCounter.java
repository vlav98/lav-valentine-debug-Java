package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;
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
		try (BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"))) {
			String line = reader.readLine();

			int headCount = 0;
			while (line != null) {
				System.out.println("symptom from file: " + line);
				if (line.equals("headache")) {
					headCount++;
					System.out.println("number of headaches: " + headCount);
				} else if (line.equals("rush")) {
					rashCount++;
				} else if (line.contains("pupils")) {
					pupilCount++;
				} else {
					break;
				}

				line = reader.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (FileWriter writer = new FileWriter("result.out")) {
			writer.write("headache: " + headacheCount + "\n");
			writer.write("rash: " + rashCount + "\n");
			writer.write("dialated pupils: " + pupilCount + "\n");
			writer.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
