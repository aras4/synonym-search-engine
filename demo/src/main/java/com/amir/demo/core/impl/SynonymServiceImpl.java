package com.amir.demo.core.impl;

import org.springframework.stereotype.Component;

import com.amir.demo.core.enums.ResponseCode;
import com.amir.demo.core.model.PayloadResponse;
import com.amir.demo.service.SynonymService;

@Component
public class SynonymServiceImpl implements SynonymService {

	@Override
	public PayloadResponse<String> getAll() {
		return new PayloadResponse<>(ResponseCode.SUCCESSFUL, "No data");
	}

}
