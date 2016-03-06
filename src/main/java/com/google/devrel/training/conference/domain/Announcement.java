package com.google.devrel.training.conference.domain;

import java.io.Serializable;

public class Announcement implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4165662681228239102L;
	
	private String message;

	public Announcement() {
	}

	public Announcement(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "Announcement [message=" + message + "]";
	}
	
}