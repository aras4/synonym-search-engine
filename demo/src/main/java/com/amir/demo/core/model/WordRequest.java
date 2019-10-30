package com.amir.demo.core.model;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WordRequest implements Serializable {

	private static final long serialVersionUID = -412931276393501714L;

	private String word;
	private List<String> synonyms;

}
