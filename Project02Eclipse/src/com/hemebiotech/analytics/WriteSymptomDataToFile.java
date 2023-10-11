package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.Map;

/**
 * Simple brute force implementation
 *
 */
public class WriteSymptomDataToFile implements ISymptomWriter {
	private String filepath;

	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *                 one per line
	 */
	public WriteSymptomDataToFile(String filepath) {
		this.filepath = filepath;
	}

	@Override
	public void WriteSymptoms(Map<String, Integer> symptoms) {
		if (filepath != null) {
			try (FileWriter writer = new FileWriter("result.out")) {
				for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
					writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
				}
				writer.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
