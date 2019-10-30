package com.amir.demo.core.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.amir.demo.core.model.WordRequest;
import com.amir.demo.core.model.WordResponse;

@Component
public class Store {

	private final Map<String, List<String>> map = new HashMap<>();

	public void addWord(WordRequest word) {
		map.put(word.getWord(), word.getSynonyms());
	}

	public List<WordResponse> getAll() {
		final List<WordResponse> all = new ArrayList<>();
		map.forEach((k, v) -> all.add(WordResponse.builder().word(k).synonyms(v).build()));
		return all;
	}

}
