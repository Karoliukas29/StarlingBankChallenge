package com.example.starlingbankchallenge.model.spaces;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Target implements Parcelable {

	@SerializedName("currency")
	private String currency;

	@SerializedName("minorUnits")
	private int minorUnits;

	public Target(String currency, int minorUnits) {
		this.currency = currency;
		this.minorUnits = minorUnits;
	}

	public Target() {

	}

	protected Target(Parcel in) {
		currency = in.readString();
		minorUnits = in.readInt();
	}

	public static final Creator<Target> CREATOR = new Creator<Target>() {
		@Override
		public Target createFromParcel(Parcel in) {
			return new Target(in);
		}

		@Override
		public Target[] newArray(int size) {
			return new Target[size];
		}
	};

	public String getCurrency(){
		return currency;
	}

	public int getMinorUnits(){
		return minorUnits;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(currency);
		parcel.writeInt(minorUnits);
	}
}