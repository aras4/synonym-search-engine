package com.amir.demo.core.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.amir.demo.core.enums.ResponseCode;
import com.amir.demo.core.model.PayloadResponse;
import com.amir.demo.core.model.WordRequest;
import com.amir.demo.core.model.WordResponse;
import com.amir.demo.core.repository.Store;
import com.amir.demo.service.SynonymService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SynonymServiceImpl implements SynonymService {

	private final Store store;

	public SynonymServiceImpl(Store store) {
		this.store = store;
	}

	@Override
	public PayloadResponse<List<WordResponse>> getAll() {
		log.info("Retrieve all words and their synonyms");
		final List<WordResponse> response = store.getAll();
		return new PayloadResponse<>(ResponseCode.SUCCESSFUL, response);
	}

	@Override
	public PayloadResponse<String> save(WordRequest word) {
		log.info("Adding new word");
		store.addWord(word);
		return new PayloadResponse<>(ResponseCode.SUCCESSFUL, "New Word successfully added");
	}

	@Override
	public PayloadResponse<List<String>> search(WordRequest request) {
		log.info("Search for synonyms");
		final List<String> response = store.search(request.getWord());
		return new PayloadResponse<>(ResponseCode.SUCCESSFUL, response);
	}

	@Override
	public PayloadResponse<String> delete() {
		log.info("Delete all words");
		store.deleteAll();
		return new PayloadResponse<>(ResponseCode.SUCCESSFUL, "Successfully removed all");
	}

}
