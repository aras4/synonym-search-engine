package com.amir.demo.core.model;

import java.io.Serializable;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class WordResponse implements Serializable {

	private static final long serialVersionUID = -3334742375239774172L;
	private String word;
	private List<String> synonyms;

}
