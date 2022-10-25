package com.example.starlingbankchallenge.model.transactions;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class SourceAmount implements Parcelable {

	@SerializedName("currency")
	private String currency;

	@SerializedName("minorUnits")
	private int minorUnits;

	public SourceAmount(String currency, int minorUnits) {
		this.currency = currency;
		this.minorUnits = minorUnits;
	}

	public SourceAmount() {

	}

	protected SourceAmount(Parcel in) {
		currency = in.readString();
		minorUnits = in.readInt();
	}

	public static final Creator<SourceAmount> CREATOR = new Creator<SourceAmount>() {
		@Override
		public SourceAmount createFromParcel(Parcel in) {
			return new SourceAmount(in);
		}

		@Override
		public SourceAmount[] newArray(int size) {
			return new SourceAmount[size];
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