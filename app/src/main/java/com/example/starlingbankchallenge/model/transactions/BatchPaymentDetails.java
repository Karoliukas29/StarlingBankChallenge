package com.example.starlingbankchallenge.model.transactions;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class BatchPaymentDetails implements Parcelable {

	@SerializedName("batchPaymentUid")
	private String batchPaymentUid;

	@SerializedName("batchPaymentType")
	private String batchPaymentType;

	public BatchPaymentDetails(String batchPaymentUid, String batchPaymentType) {
		this.batchPaymentUid = batchPaymentUid;
		this.batchPaymentType = batchPaymentType;
	}

	public BatchPaymentDetails() {

	}

	protected BatchPaymentDetails(Parcel in) {
		batchPaymentUid = in.readString();
		batchPaymentType = in.readString();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(batchPaymentUid);
		dest.writeString(batchPaymentType);
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public static final Creator<BatchPaymentDetails> CREATOR = new Creator<BatchPaymentDetails>() {
		@Override
		public BatchPaymentDetails createFromParcel(Parcel in) {
			return new BatchPaymentDetails(in);
		}

		@Override
		public BatchPaymentDetails[] newArray(int size) {
			return new BatchPaymentDetails[size];
		}
	};

	public String getBatchPaymentUid(){
		return batchPaymentUid;
	}

	public String getBatchPaymentType(){
		return batchPaymentType;
	}
}