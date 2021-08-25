package com.cg.fds.exception;

@SuppressWarnings("serial")
public class UserNameAlreadyExistsException extends Exception{
	public UserNameAlreadyExistsException(String msg) {
		super(msg);
	}
}
