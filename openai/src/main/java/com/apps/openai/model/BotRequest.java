package com.apps.openai.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class BotRequest implements Serializable {
  
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


}