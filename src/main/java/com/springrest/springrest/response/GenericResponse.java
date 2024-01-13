package com.springrest.springrest.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import ch.qos.logback.core.status.Status;

public class GenericResponse extends ResponseEntity<Status> {
	private String ed;
	
	public GenericResponse() {
		super(HttpStatus.INTERNAL_SERVER_ERROR);
		// TODO Auto-generated constructor stub
	}

	public GenericResponse(String ed, HttpStatus status) {
		super(status);
		this.ed = ed;
	}

	public String getEd() {
		return ed;
	}

	public void setEd(String ed) {
		this.ed = ed;
	}
}
