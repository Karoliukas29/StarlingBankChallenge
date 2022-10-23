package com.example.starlingbankchallenge.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class AccountsItem implements Parcelable {

	@SerializedName("createdAt")
	private String createdAt;

	@SerializedName("defaultCategory")
	private String defaultCategory;

	@SerializedName("accountType")
	private String accountType;

	@SerializedName("name")
	private String name;

	@SerializedName("currency")
	private String currency;

	@SerializedName("accountUid")
	private String accountUid;

	protected AccountsItem(Parcel in) {
		createdAt = in.readString();
		defaultCategory = in.readString();
		accountType = in.readString();
		name = in.readString();
		currency = in.readString();
		accountUid = in.readString();
	}

	public static final Creator<AccountsItem> CREATOR = new Creator<AccountsItem>() {
		@Override
		public AccountsItem createFromParcel(Parcel in) {
			return new AccountsItem(in);
		}

		@Override
		public AccountsItem[] newArray(int size) {
			return new AccountsItem[size];
		}
	};

	public String getCreatedAt(){
		return createdAt;
	}

	public String getDefaultCategory(){
		return defaultCategory;
	}

	public String getAccountType(){
		return accountType;
	}

	public String getName(){
		return name;
	}

	public String getCurrency(){
		return currency;
	}

	public String getAccountUid(){
		return accountUid;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(createdAt);
		parcel.writeString(defaultCategory);
		parcel.writeString(accountType);
		parcel.writeString(name);
		parcel.writeString(currency);
		parcel.writeString(accountUid);
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public void setDefaultCategory(String defaultCategory) {
		this.defaultCategory = defaultCategory;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public void setAccountUid(String accountUid) {
		this.accountUid = accountUid;
	}
}