package com.amir.demo.core.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.amir.demo.core.model.WordRequest;
import com.amir.demo.core.model.WordResponse;
import com.amir.demo.core.repository.Store;

public class SynonymServiceImplTest {

	@InjectMocks
	SynonymServiceImpl synonymServiceImpl;

	@Mock
	Store store;

	/**
	 * Before Method which will be used to startup whatever is needed for
	 * execution of tests.
	 */
	@BeforeSuite
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	protected void getAll() {

		final List<WordResponse> list = new ArrayList<>();
		list.add(WordResponse.builder().word("a").synonyms(Arrays.asList("b")).build());

		when(store.getAll()).thenReturn(list);
		// test
		final List<WordResponse> wordList = synonymServiceImpl.getAll().getPayload();

		assertEquals(1, wordList.size());
		verify(store, times(1)).getAll();
	}

	@Test
	protected void save() {
		final WordRequest request = new WordRequest();
		request.setWord("a");
		request.setSynonyms(Arrays.asList("b"));

		// test
		final String response = synonymServiceImpl.save(request).getPayload();

		assertEquals("New Word successfully added", response);
		verify(store, times(1)).addWord(request);
	}

	@Test
	protected void search() {

		final String word1 = "test";
		final WordRequest request = WordRequest.builder().word(word1).build();

		when(store.search(word1)).thenReturn(Arrays.asList("a", "b"));
		// test
		final List<String> wordList = synonymServiceImpl.search(request).getPayload();

		assertEquals(2, wordList.size());
		verify(store, times(1)).search(word1);
	}

	@Test
	protected void delete() {
		// test
		final String response = synonymServiceImpl.delete().getPayload();

		assertEquals("Successfully removed all", response);
		verify(store, times(1)).deleteAll();
	}

}
