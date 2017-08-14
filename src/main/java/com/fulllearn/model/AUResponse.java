package com.fulllearn.model;

import java.util.Map;

public class AUResponse {
	private String msg;
	private boolean response;
	private String status;
	private int code;
	private String error;
	private Map<String, ChallengeDetail> data;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isResponse() {
		return response;
	}

	public void setResponse(boolean response) {
		this.response = response;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Map<String, ChallengeDetail> getData() {
		return data;
	}

	public void setData(Map<String, ChallengeDetail> data) {
		this.data = data;
	}

}
