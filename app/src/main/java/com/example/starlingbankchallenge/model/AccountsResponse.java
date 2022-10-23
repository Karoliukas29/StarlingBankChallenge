package com.example.starlingbankchallenge.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class AccountsResponse implements Parcelable {

	@SerializedName("accounts")
	private List<AccountsItem> accounts;

	protected AccountsResponse(Parcel in) {
		accounts = in.createTypedArrayList(AccountsItem.CREATOR);
	}

	public static final Creator<AccountsResponse> CREATOR = new Creator<AccountsResponse>() {
		@Override
		public AccountsResponse createFromParcel(Parcel in) {
			return new AccountsResponse(in);
		}

		@Override
		public AccountsResponse[] newArray(int size) {
			return new AccountsResponse[size];
		}
	};

	public List<AccountsItem> getAccounts(){
		return accounts;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeTypedList(accounts);
	}

	public void setAccounts(List<AccountsItem> accounts) {
		this.accounts = accounts;
	}
}