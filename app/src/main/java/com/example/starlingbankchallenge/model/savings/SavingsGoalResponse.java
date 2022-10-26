package com.example.starlingbankchallenge.model.savings;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class SavingsGoalResponse{

	@SerializedName("savingsGoalUid")
	private String savingsGoalUid;

	@SerializedName("success")
	private boolean success;

	@SerializedName("errors")
	private List<ErrorsItem> errors;

	public String getSavingsGoalUid(){
		return savingsGoalUid;
	}

	public boolean isSuccess(){
		return success;
	}

	public List<ErrorsItem> getErrors(){
		return errors;
	}
}