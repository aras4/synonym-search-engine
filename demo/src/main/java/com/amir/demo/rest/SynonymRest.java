package com.amir.demo.rest;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amir.demo.core.model.PayloadResponse;
import com.amir.demo.core.model.WordRequest;
import com.amir.demo.core.model.WordResponse;
import com.amir.demo.service.SynonymService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "synonyms")
@RequestMapping(value = "/synonyms")
@CrossOrigin
public class SynonymRest {

	private final SynonymService synonymService;

	public SynonymRest(SynonymService synonymService) {
		this.synonymService = synonymService;
	}

	@ApiOperation(value = "Retrieve all words and their synonyms", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@GetMapping(value = "/words")
	public PayloadResponse<List<WordResponse>> getAll() {
		return synonymService.getAll();
	}

	@ApiOperation(value = "Add new word", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@PostMapping(value = "/word")
	public PayloadResponse<String> save(@RequestBody WordRequest request) {
		return synonymService.save(request);
	}

	@ApiOperation(value = "Delete all", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@DeleteMapping(value = "/word")
	public PayloadResponse<String> delete() {
		return synonymService.delete();
	}

	@ApiOperation(value = "Search for words and their synonyms", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@GetMapping(value = "/search/{word}")
	public PayloadResponse<List<String>> search(@PathVariable String word) {
		final WordRequest request = WordRequest.builder().word(word).build();
		return synonymService.search(request);
	}

}
