package com.example.starlingbankchallenge.model.spaces;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class TotalSaved implements Parcelable {

	@SerializedName("currency")
	private String currency;

	@SerializedName("minorUnits")
	private int minorUnits;

	public TotalSaved(String currency, int minorUnits) {
		this.currency = currency;
		this.minorUnits = minorUnits;
	}

	public TotalSaved() {

	}

	protected TotalSaved(Parcel in) {
		currency = in.readString();
		minorUnits = in.readInt();
	}

	public static final Creator<TotalSaved> CREATOR = new Creator<TotalSaved>() {
		@Override
		public TotalSaved createFromParcel(Parcel in) {
			return new TotalSaved(in);
		}

		@Override
		public TotalSaved[] newArray(int size) {
			return new TotalSaved[size];
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