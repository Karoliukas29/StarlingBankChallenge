package com.example.starlingbankchallenge.model.transactions;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class TransactionResponse implements Parcelable {

	@SerializedName("TransactionResponse")
	private List<TransactionResponseItem> transactionResponse;

	protected TransactionResponse(Parcel in) {
		transactionResponse = in.createTypedArrayList(TransactionResponseItem.CREATOR);
	}

	public static final Creator<TransactionResponse> CREATOR = new Creator<TransactionResponse>() {
		@Override
		public TransactionResponse createFromParcel(Parcel in) {
			return new TransactionResponse(in);
		}

		@Override
		public TransactionResponse[] newArray(int size) {
			return new TransactionResponse[size];
		}
	};

	public List<TransactionResponseItem> getTransactionResponse(){
		return transactionResponse;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeTypedList(transactionResponse);
	}
}