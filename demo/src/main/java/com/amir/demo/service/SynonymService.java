package com.amir.demo.service;

import com.amir.demo.core.model.PayloadResponse;

public interface SynonymService {

	/**
	 * Retrieve all synonyms {@link String}. <br>
	 * 
	 * @return {@link PayloadResponse} holding all words {@link String}.
	 */
	PayloadResponse<String> getAll();

}
