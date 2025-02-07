package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Anything that will read symptom data from a source
 * The important part is, the return value from the operation, which is a list
 * of strings, that may contain many duplications
 * 
 * The implementation does not need to order the list
 */
public interface ISymptomWriter {
	/**
	 * Create a new file with all symptoms
	 */
	void writeSymptoms(Map<String, Integer> symptoms);
}
