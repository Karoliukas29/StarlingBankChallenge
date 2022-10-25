package com.example.starlingbankchallenge.model.transactions;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class RoundUp implements Parcelable {

	@SerializedName("amount")
	private Amount amount;

	@SerializedName("goalCategoryUid")
	private String goalCategoryUid;

	public RoundUp(Amount amount, String goalCategoryUid) {
		this.amount = amount;
		this.goalCategoryUid = goalCategoryUid;
	}

	public RoundUp() {

	}

	protected RoundUp(Parcel in) {
		goalCategoryUid = in.readString();
	}

	public static final Creator<RoundUp> CREATOR = new Creator<RoundUp>() {
		@Override
		public RoundUp createFromParcel(Parcel in) {
			return new RoundUp(in);
		}

		@Override
		public RoundUp[] newArray(int size) {
			return new RoundUp[size];
		}
	};

	public Amount getAmount(){
		return amount;
	}

	public String getGoalCategoryUid(){
		return goalCategoryUid;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(goalCategoryUid);
	}
}