package com.example.postgresql.exception;

public class AccessForbiddenException extends RuntimeException {

	public AccessForbiddenException(String msg) {
		super(msg);
	}

}
