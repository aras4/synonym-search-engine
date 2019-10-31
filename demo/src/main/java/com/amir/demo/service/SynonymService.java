package com.amir.demo.service;

import java.util.List;

import com.amir.demo.core.model.PayloadResponse;
import com.amir.demo.core.model.WordRequest;
import com.amir.demo.core.model.WordResponse;

public interface SynonymService {

	/**
	 * Retrieve all synonyms {@link String}. <br>
	 * 
	 * @return {@link PayloadResponse} holding all words with synonyms
	 *         {@link WordResponse}.
	 */
	PayloadResponse<List<WordResponse>> getAll();

	/**
	 * Add new word {@link String}. <br>
	 * 
	 * @param new
	 *            word {@link WordRequest}
	 * @return {@link PayloadResponse} holding all words {@link String}.
	 */
	PayloadResponse<String> save(WordRequest word);

	/**
	 * Retrieve all synonyms for given word {@link String}. <br>
	 * 
	 * @return {@link PayloadResponse} holding all words with synonyms
	 *         {@link WordResponse}.
	 */
	PayloadResponse<List<String>> search(WordRequest request);

	/**
	 * Delete all synonyms. <br>
	 * 
	 * @return {@link PayloadResponse} message of {@link String}.
	 */
	PayloadResponse<String> delete();

}
