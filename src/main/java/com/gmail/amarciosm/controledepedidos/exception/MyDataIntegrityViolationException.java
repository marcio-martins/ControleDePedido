package com.gmail.amarciosm.controledepedidos.exception;

public class MyDataIntegrityViolationException extends RuntimeException {
	
	private static final long serialVersionUID = -2854672367202724015L;

	public MyDataIntegrityViolationException(String msg) {
		super(msg);
	}
	
	public MyDataIntegrityViolationException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
