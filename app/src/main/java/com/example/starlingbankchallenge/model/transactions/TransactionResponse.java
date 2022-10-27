package com.example.starlingbankchallenge.model.transactions;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class TransactionResponse implements Parcelable {

	@SerializedName("feedItems")
	private List<FeedItemsItem> feedItems;

	public TransactionResponse(List<FeedItemsItem> feedItems) {
		this.feedItems = feedItems;
	}

	public TransactionResponse() {
	}

	protected TransactionResponse(Parcel in) {
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
	}

	@Override
	public int describeContents() {
		return 0;
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



	public List<FeedItemsItem> getFeedItems(){
		return feedItems;
	}
}