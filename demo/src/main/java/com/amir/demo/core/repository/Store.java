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

	private Map<String, List<String>> map = new HashMap<>();

	public void addWord(WordRequest word) {
		map.put(word.getWord(), word.getSynonyms());
	}

	public void deleteAll() {
		map = new HashMap<>();
	}

	public List<WordResponse> getAll() {
		final List<WordResponse> all = new ArrayList<>();
		map.forEach((k, v) -> all.add(WordResponse.builder().word(k).synonyms(v).build()));
		return all;
	}

	public List<String> search(String word) {
		final List<String> synonyms = new ArrayList<>();
		synonyms.addAll(getValues(word));
		synonyms.addAll(getByValues(word));
		synonyms.remove(word);
		return synonyms;
	}

	public List<String> getValues(String key) {
		return map.getOrDefault(key, new ArrayList<>());
	}

	public List<String> getByValues(String key) {
		final List<String> values = new ArrayList<>();
		map.entrySet().stream().filter(entry -> contains(key, entry.getValue())).forEach(m -> {
			values.add(m.getKey());
			values.addAll(m.getValue());
		});
		return values;
	}

	public boolean contains(String s, List<String> l) {
		return l.stream().anyMatch(x -> x.equals(s));
	}

}
