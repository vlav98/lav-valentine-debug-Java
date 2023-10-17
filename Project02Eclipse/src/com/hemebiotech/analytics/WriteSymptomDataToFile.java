package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Map;

/**
 * Write every symptom data and their count in a file with the file path given
 */
public class WriteSymptomDataToFile implements ISymptomWriter {
	private String filePath;

	/**
	 * 
	 * @param filePath a full or partial path to file with symptom strings in it,
	 *                 one per line
	 */
	public WriteSymptomDataToFile(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * Write in a file every symptoms and their occurence value
	 */
	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
		if (filePath != null) {
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
				for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
					writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
				}
			} catch (Exception e) {
				System.err.println("Error while writing file " + e.getMessage() + " caused by " + e.getCause());
			}
		}
	}

}
