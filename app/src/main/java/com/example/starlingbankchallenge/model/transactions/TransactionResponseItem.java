package com.example.starlingbankchallenge.model.transactions;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class TransactionResponseItem implements Parcelable {

	@SerializedName("country")
	private String country;

	@SerializedName("amount")
	private Amount amount;

	@SerializedName("counterPartyType")
	private String counterPartyType;

	@SerializedName("counterPartySubEntityUid")
	private String counterPartySubEntityUid;

	@SerializedName("source")
	private String source;

	@SerializedName("counterPartyUid")
	private String counterPartyUid;

	@SerializedName("counterPartyName")
	private String counterPartyName;

	@SerializedName("counterPartySubEntityName")
	private String counterPartySubEntityName;

	@SerializedName("transactionTime")
	private String transactionTime;

	@SerializedName("counterPartySubEntityIdentifier")
	private String counterPartySubEntityIdentifier;

	@SerializedName("reference")
	private String reference;

	@SerializedName("hasAttachment")
	private boolean hasAttachment;

	@SerializedName("settlementTime")
	private String settlementTime;

	@SerializedName("transactingApplicationUserUid")
	private String transactingApplicationUserUid;

	@SerializedName("feedItemUid")
	private String feedItemUid;

	@SerializedName("counterPartySubEntitySubIdentifier")
	private String counterPartySubEntitySubIdentifier;

	@SerializedName("hasReceipt")
	private boolean hasReceipt;

	@SerializedName("categoryUid")
	private String categoryUid;

	@SerializedName("sourceAmount")
	private SourceAmount sourceAmount;

	@SerializedName("spendingCategory")
	private String spendingCategory;

	@SerializedName("batchPaymentDetails")
	private Object batchPaymentDetails;

	@SerializedName("direction")
	private String direction;

	@SerializedName("updatedAt")
	private String updatedAt;

	@SerializedName("status")
	private String status;

	protected TransactionResponseItem(Parcel in) {
		country = in.readString();
		counterPartyType = in.readString();
		counterPartySubEntityUid = in.readString();
		source = in.readString();
		counterPartyUid = in.readString();
		counterPartyName = in.readString();
		counterPartySubEntityName = in.readString();
		transactionTime = in.readString();
		counterPartySubEntityIdentifier = in.readString();
		reference = in.readString();
		hasAttachment = in.readByte() != 0;
		settlementTime = in.readString();
		transactingApplicationUserUid = in.readString();
		feedItemUid = in.readString();
		counterPartySubEntitySubIdentifier = in.readString();
		hasReceipt = in.readByte() != 0;
		categoryUid = in.readString();
		spendingCategory = in.readString();
		direction = in.readString();
		updatedAt = in.readString();
		status = in.readString();
	}

	public static final Creator<TransactionResponseItem> CREATOR = new Creator<TransactionResponseItem>() {
		@Override
		public TransactionResponseItem createFromParcel(Parcel in) {
			return new TransactionResponseItem(in);
		}

		@Override
		public TransactionResponseItem[] newArray(int size) {
			return new TransactionResponseItem[size];
		}
	};

	public String getCountry(){
		return country;
	}

	public Amount getAmount(){
		return amount;
	}

	public String getCounterPartyType(){
		return counterPartyType;
	}

	public String getCounterPartySubEntityUid(){
		return counterPartySubEntityUid;
	}

	public String getSource(){
		return source;
	}

	public String getCounterPartyUid(){
		return counterPartyUid;
	}

	public String getCounterPartyName(){
		return counterPartyName;
	}

	public String getCounterPartySubEntityName(){
		return counterPartySubEntityName;
	}

	public String getTransactionTime(){
		return transactionTime;
	}

	public String getCounterPartySubEntityIdentifier(){
		return counterPartySubEntityIdentifier;
	}

	public String getReference(){
		return reference;
	}

	public boolean isHasAttachment(){
		return hasAttachment;
	}

	public String getSettlementTime(){
		return settlementTime;
	}

	public String getTransactingApplicationUserUid(){
		return transactingApplicationUserUid;
	}

	public String getFeedItemUid(){
		return feedItemUid;
	}

	public String getCounterPartySubEntitySubIdentifier(){
		return counterPartySubEntitySubIdentifier;
	}

	public boolean isHasReceipt(){
		return hasReceipt;
	}

	public String getCategoryUid(){
		return categoryUid;
	}

	public SourceAmount getSourceAmount(){
		return sourceAmount;
	}

	public String getSpendingCategory(){
		return spendingCategory;
	}

	public Object getBatchPaymentDetails(){
		return batchPaymentDetails;
	}

	public String getDirection(){
		return direction;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public String getStatus(){
		return status;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(country);
		parcel.writeString(counterPartyType);
		parcel.writeString(counterPartySubEntityUid);
		parcel.writeString(source);
		parcel.writeString(counterPartyUid);
		parcel.writeString(counterPartyName);
		parcel.writeString(counterPartySubEntityName);
		parcel.writeString(transactionTime);
		parcel.writeString(counterPartySubEntityIdentifier);
		parcel.writeString(reference);
		parcel.writeByte((byte) (hasAttachment ? 1 : 0));
		parcel.writeString(settlementTime);
		parcel.writeString(transactingApplicationUserUid);
		parcel.writeString(feedItemUid);
		parcel.writeString(counterPartySubEntitySubIdentifier);
		parcel.writeByte((byte) (hasReceipt ? 1 : 0));
		parcel.writeString(categoryUid);
		parcel.writeString(spendingCategory);
		parcel.writeString(direction);
		parcel.writeString(updatedAt);
		parcel.writeString(status);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TransactionResponseItem that = (TransactionResponseItem) o;
		return hasAttachment == that.hasAttachment && hasReceipt == that.hasReceipt && Objects.equals(country, that.country) && Objects.equals(amount, that.amount) && Objects.equals(counterPartyType, that.counterPartyType) && Objects.equals(counterPartySubEntityUid, that.counterPartySubEntityUid) && Objects.equals(source, that.source) && Objects.equals(counterPartyUid, that.counterPartyUid) && Objects.equals(counterPartyName, that.counterPartyName) && Objects.equals(counterPartySubEntityName, that.counterPartySubEntityName) && Objects.equals(transactionTime, that.transactionTime) && Objects.equals(counterPartySubEntityIdentifier, that.counterPartySubEntityIdentifier) && Objects.equals(reference, that.reference) && Objects.equals(settlementTime, that.settlementTime) && Objects.equals(transactingApplicationUserUid, that.transactingApplicationUserUid) && Objects.equals(feedItemUid, that.feedItemUid) && Objects.equals(counterPartySubEntitySubIdentifier, that.counterPartySubEntitySubIdentifier) && Objects.equals(categoryUid, that.categoryUid) && Objects.equals(sourceAmount, that.sourceAmount) && Objects.equals(spendingCategory, that.spendingCategory) && Objects.equals(batchPaymentDetails, that.batchPaymentDetails) && Objects.equals(direction, that.direction) && Objects.equals(updatedAt, that.updatedAt) && Objects.equals(status, that.status);
	}

	@Override
	public int hashCode() {
		return Objects.hash(country, amount, counterPartyType, counterPartySubEntityUid, source, counterPartyUid, counterPartyName, counterPartySubEntityName, transactionTime, counterPartySubEntityIdentifier, reference, hasAttachment, settlementTime, transactingApplicationUserUid, feedItemUid, counterPartySubEntitySubIdentifier, hasReceipt, categoryUid, sourceAmount, spendingCategory, batchPaymentDetails, direction, updatedAt, status);
	}
}