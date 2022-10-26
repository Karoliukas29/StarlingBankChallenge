package com.example.starlingbankchallenge.model.spaces;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class SpendingSpacesItem implements Parcelable {

	@SerializedName("cardAssociationUid")
	private String cardAssociationUid;

	@SerializedName("spaceUid")
	private String spaceUid;

	@SerializedName("balance")
	private Balance balance;

	@SerializedName("sortOrder")
	private int sortOrder;

	@SerializedName("name")
	private String name;

	@SerializedName("spendingSpaceType")
	private String spendingSpaceType;

	public SpendingSpacesItem(String cardAssociationUid, String spaceUid, Balance balance, int sortOrder, String name, String spendingSpaceType) {
		this.cardAssociationUid = cardAssociationUid;
		this.spaceUid = spaceUid;
		this.balance = balance;
		this.sortOrder = sortOrder;
		this.name = name;
		this.spendingSpaceType = spendingSpaceType;
	}

	public SpendingSpacesItem() {
	}

	protected SpendingSpacesItem(Parcel in) {
		cardAssociationUid = in.readString();
		spaceUid = in.readString();
		sortOrder = in.readInt();
		name = in.readString();
		spendingSpaceType = in.readString();
	}

	public static final Creator<SpendingSpacesItem> CREATOR = new Creator<SpendingSpacesItem>() {
		@Override
		public SpendingSpacesItem createFromParcel(Parcel in) {
			return new SpendingSpacesItem(in);
		}

		@Override
		public SpendingSpacesItem[] newArray(int size) {
			return new SpendingSpacesItem[size];
		}
	};

	public String getCardAssociationUid(){
		return cardAssociationUid;
	}

	public String getSpaceUid(){
		return spaceUid;
	}

	public Balance getBalance(){
		return balance;
	}

	public int getSortOrder(){
		return sortOrder;
	}

	public String getName(){
		return name;
	}

	public String getSpendingSpaceType(){
		return spendingSpaceType;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(cardAssociationUid);
		parcel.writeString(spaceUid);
		parcel.writeInt(sortOrder);
		parcel.writeString(name);
		parcel.writeString(spendingSpaceType);
	}
}