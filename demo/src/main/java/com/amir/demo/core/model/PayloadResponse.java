package com.amir.demo.core.model;

import java.io.Serializable;
import java.util.UUID;

import com.amir.demo.core.enums.ResponseCode;

/**
 * Class intended to be used as a base class for all responses that require a
 * payload to be returned
 * 
 * @param <T>
 *            the type of the payload
 * @author amir
 */
public class PayloadResponse<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	private ResponseCode code;
	private T payload;
	private String tid;

	public PayloadResponse() {
		this(null, null);
	}

	/**
	 * constructor
	 * 
	 * @param code
	 *            the {@link ResponseCode} to encapsulate in a response
	 * @param payload
	 *            the payload to set
	 */
	public PayloadResponse(final ResponseCode code, final T payload) {
		this.code = code;
		this.payload = payload;
		this.setTid(this.generateUUID());
	}

	/**
	 * @return the payload
	 */
	public T getPayload() {
		return this.payload;
	}

	/**
	 * @param payload
	 *            the payload to set
	 */
	public void setPayload(final T payload) {
		this.payload = payload;
	}

	/**
	 * @return the code
	 */
	public ResponseCode getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(ResponseCode code) {
		this.code = code;
	}

	/**
	 * @return the tid
	 */
	public String getTid() {
		return tid;
	}

	/**
	 * @param tid
	 *            the tid to set
	 */
	public void setTid(String tid) {
		this.tid = tid;
	}

	private String generateUUID() {
		return UUID.randomUUID().toString();
	}
}
