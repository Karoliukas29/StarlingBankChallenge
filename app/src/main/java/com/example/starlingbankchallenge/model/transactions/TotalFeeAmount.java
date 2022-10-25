package com.example.starlingbankchallenge.model.transactions;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class TotalFeeAmount implements Parcelable {

	@SerializedName("currency")
	private String currency;

	@SerializedName("minorUnits")
	private int minorUnits;


	public TotalFeeAmount(String currency, int minorUnits) {
		this.currency = currency;
		this.minorUnits = minorUnits;
	}

	public TotalFeeAmount() {

	}

	protected TotalFeeAmount(Parcel in) {
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

	public static final Creator<TotalFeeAmount> CREATOR = new Creator<TotalFeeAmount>() {
		@Override
		public TotalFeeAmount createFromParcel(Parcel in) {
			return new TotalFeeAmount(in);
		}

		@Override
		public TotalFeeAmount[] newArray(int size) {
			return new TotalFeeAmount[size];
		}
	};

	public String getCurrency(){
		return currency;
	}

	public int getMinorUnits(){
		return minorUnits;
	}
}