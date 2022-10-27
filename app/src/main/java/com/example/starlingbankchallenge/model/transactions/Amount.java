package com.example.starlingbankchallenge.model.transactions;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Amount implements Parcelable {

	@SerializedName("currency")
	private String currency;

	@SerializedName("minorUnits")
	private int minorUnits;

	public Amount(String currency, int minorUnits) {
		this.currency = currency;
		this.minorUnits = minorUnits;
	}

	public Amount() {

	}

	protected Amount(Parcel in) {
		currency = in.readString();
		minorUnits = in.readInt();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(currency);
		dest.writeInt(minorUnits);
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public static final Creator<Amount> CREATOR = new Creator<Amount>() {
		@Override
		public Amount createFromParcel(Parcel in) {
			return new Amount(in);
		}

		@Override
		public Amount[] newArray(int size) {
			return new Amount[size];
		}
	};

	public String getCurrency(){
		return currency;
	}

	public int getMinorUnits(){
		return minorUnits;
	}
}