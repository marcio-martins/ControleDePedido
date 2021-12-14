package com.gmail.amarciosm.controledepedidos.exception;

public class MyObjectNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = -2854672367202724015L;

	public MyObjectNotFoundException(String msg) {
		super(msg);
	}
	
	public MyObjectNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
