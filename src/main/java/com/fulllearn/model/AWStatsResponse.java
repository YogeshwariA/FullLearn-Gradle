package com.fulllearn.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AWStatsResponse {
	private boolean response;
	private String errors;
	private AWStatsData data;

	public boolean isResponse() {
		return response;
	}

	public void setResponse(boolean response) {
		this.response = response;
	}

	public String getErrors() {
		return errors;
	}

	public void setErrors(String errors) {
		this.errors = errors;
	}

	public AWStatsData getData() {
		return data;
	}

	public void setData(AWStatsData data) {
		this.data = data;
	}

}
