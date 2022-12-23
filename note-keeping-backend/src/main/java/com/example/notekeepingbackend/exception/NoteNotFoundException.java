package com.example.notekeepingbackend.exception;

public class NoteNotFoundException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoteNotFoundException(String message) {
		super(message);
	}

}
