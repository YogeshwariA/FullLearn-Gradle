package com.fulllearn.model;

public class AWResponse {
	private boolean ok;
	private AWData data;
    private String errors;
	
	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	public AWData getData() {
		return data;
	}

	public void setData(AWData data) {
		this.data = data;
	}

	public String getErrors() {
		return errors;
	}

	public void setErrors(String errors) {
		this.errors = errors;
	}
	
	

}
