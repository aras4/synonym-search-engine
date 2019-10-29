package com.amir.demo.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amir.demo.core.model.PayloadResponse;
import com.amir.demo.service.SynonymService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "synonyms")
@RequestMapping(value = "/synonyms")
public class SynonymRest {

	private final SynonymService synonymService;

	public SynonymRest(SynonymService synonymService) {
		this.synonymService = synonymService;
	}

	@ApiOperation(value = "Retrieve all words and their synonyms", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@GetMapping(value = "/words")
	public PayloadResponse<String> getAll() {
		return synonymService.getAll();
	}

}
