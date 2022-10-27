package com.example.starlingbankchallenge.model.spaces;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Balance implements Parcelable {

	@SerializedName("currency")
	private String currency;

	@SerializedName("minorUnits")
	private int minorUnits;

	public Balance(String currency, int minorUnits) {
		this.currency = currency;
		this.minorUnits = minorUnits;
	}

	public Balance() {
	}

	protected Balance(Parcel in) {
		currency = in.readString();
		minorUnits = in.readInt();
	}

	public static final Creator<Balance> CREATOR = new Creator<Balance>() {
		@Override
		public Balance createFromParcel(Parcel in) {
			return new Balance(in);
		}

		@Override
		public Balance[] newArray(int size) {
			return new Balance[size];
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