package com.cg.fds.exception;

@SuppressWarnings("serial")
public class NoSuchUserException extends Exception{
	public NoSuchUserException(String msg) {
		super(msg);
	}
}
