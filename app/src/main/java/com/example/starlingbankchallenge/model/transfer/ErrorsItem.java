package com.example.starlingbankchallenge.model.transfer;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class ErrorsItem implements Parcelable {

	@SerializedName("message")
	private String message;

	protected ErrorsItem(Parcel in) {
		message = in.readString();
	}

	public ErrorsItem(String message) {
		this.message = message;
	}

	public ErrorsItem() {
	}

	public static final Creator<ErrorsItem> CREATOR = new Creator<ErrorsItem>() {
		@Override
		public ErrorsItem createFromParcel(Parcel in) {
			return new ErrorsItem(in);
		}

		@Override
		public ErrorsItem[] newArray(int size) {
			return new ErrorsItem[size];
		}
	};

	public String getMessage(){
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(message);
	}
}