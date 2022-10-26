package com.example.starlingbankchallenge.model.spaces;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class SpacesResponse implements Parcelable {

	@SerializedName("savingsGoals")
	private List<SavingsGoalsItem> savingsGoals;

	@SerializedName("spendingSpaces")
	private List<SpendingSpacesItem> spendingSpaces;

	public SpacesResponse(List<SavingsGoalsItem> savingsGoals, List<SpendingSpacesItem> spendingSpaces) {
		this.savingsGoals = savingsGoals;
		this.spendingSpaces = spendingSpaces;
	}
	public SpacesResponse() {

	}


	protected SpacesResponse(Parcel in) {
		spendingSpaces = in.createTypedArrayList(SpendingSpacesItem.CREATOR);
	}

	public static final Creator<SpacesResponse> CREATOR = new Creator<SpacesResponse>() {
		@Override
		public SpacesResponse createFromParcel(Parcel in) {
			return new SpacesResponse(in);
		}

		@Override
		public SpacesResponse[] newArray(int size) {
			return new SpacesResponse[size];
		}
	};

	public List<SavingsGoalsItem> getSavingsGoals(){
		return savingsGoals;
	}

	public List<SpendingSpacesItem> getSpendingSpaces(){
		return spendingSpaces;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeTypedList(spendingSpaces);
	}
}