package com.example.starlingbankchallenge.model.savings;

import com.google.gson.annotations.SerializedName;

public class ErrorsItem{

	@SerializedName("message")
	private String message;

	public String getMessage(){
		return message;
	}
}