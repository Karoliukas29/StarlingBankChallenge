package com.example.starlingbankchallenge.model.transfer;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class TransferRequest implements Parcelable {

	@SerializedName("amount")
	private Amount amount;

	public TransferRequest(Amount amount) {
		this.amount = amount;
	}

	public TransferRequest(){
	}

	protected TransferRequest(Parcel in) {
		amount = in.readParcelable(Amount.class.getClassLoader());
	}

	public static final Creator<TransferRequest> CREATOR = new Creator<TransferRequest>() {
		@Override
		public TransferRequest createFromParcel(Parcel in) {
			return new TransferRequest(in);
		}

		@Override
		public TransferRequest[] newArray(int size) {
			return new TransferRequest[size];
		}
	};

	public Amount getAmount(){
		return amount;
	}

	public void setAmount(Amount amount) {
		this.amount = amount;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeParcelable(amount, i);
	}
}