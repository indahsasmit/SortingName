package com.app.util;

import org.springframework.http.HttpStatus;

public class SortedNameResponse {
    private Integer status;
    private String message;
    private Object result;
    
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	
    public SortedNameResponse() {
		
	}
    
	public SortedNameResponse(int status, String message, Object result) {
		this.status = status;
		this.message = message;
		this.result = result;
	}
	
	public static SortedNameResponse getError(HttpStatus httpStatus, String message) {
        return new SortedNameResponse(httpStatus.value(), message, null);
    }
}
