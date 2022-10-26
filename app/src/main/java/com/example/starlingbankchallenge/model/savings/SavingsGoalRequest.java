package com.example.starlingbankchallenge.model.savings;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class SavingsGoalRequest implements Parcelable {

	@SerializedName("base64EncodedPhoto")
	private String base64EncodedPhoto;

	@SerializedName("name")
	private String name;

	@SerializedName("currency")
	private String currency;

	@SerializedName("target")
	private Target target;

	public SavingsGoalRequest(String base64EncodedPhoto, String name, String currency, Target target) {
		this.base64EncodedPhoto = base64EncodedPhoto;
		this.name = name;
		this.currency = currency;
		this.target = target;
	}

	public SavingsGoalRequest() {

	}

	protected SavingsGoalRequest(Parcel in) {
		base64EncodedPhoto = in.readString();
		name = in.readString();
		currency = in.readString();
	}

	public static final Creator<SavingsGoalRequest> CREATOR = new Creator<SavingsGoalRequest>() {
		@Override
		public SavingsGoalRequest createFromParcel(Parcel in) {
			return new SavingsGoalRequest(in);
		}

		@Override
		public SavingsGoalRequest[] newArray(int size) {
			return new SavingsGoalRequest[size];
		}
	};

	public String getBase64EncodedPhoto(){
		return base64EncodedPhoto;
	}

	public String getName(){
		return name;
	}

	public String getCurrency(){
		return currency;
	}

	public Target getTarget(){
		return target;
	}

	public void setBase64EncodedPhoto(String base64EncodedPhoto) {
		this.base64EncodedPhoto = base64EncodedPhoto;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public void setTarget(Target target) {
		this.target = target;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(base64EncodedPhoto);
		parcel.writeString(name);
		parcel.writeString(currency);
	}
}