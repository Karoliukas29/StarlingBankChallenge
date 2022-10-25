package com.example.starlingbankchallenge.model.transactions;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class FeedItemsItem implements Parcelable {

	@SerializedName("totalFees")
	private int totalFees;

	@SerializedName("country")
	private String country;

	@SerializedName("counterPartyType")
	private String counterPartyType;

	@SerializedName("userNote")
	private String userNote;

	@SerializedName("counterPartySubEntityUid")
	private String counterPartySubEntityUid;

	@SerializedName("source")
	private String source;

	@SerializedName("counterPartySubEntityName")
	private String counterPartySubEntityName;

	@SerializedName("transactionTime")
	private String transactionTime;

	@SerializedName("reference")
	private String reference;

	@SerializedName("hasAttachment")
	private boolean hasAttachment;

	@SerializedName("exchangeRate")
	private int exchangeRate;

	@SerializedName("feedItemUid")
	private String feedItemUid;

	@SerializedName("hasReceipt")
	private boolean hasReceipt;

	@SerializedName("categoryUid")
	private String categoryUid;

	@SerializedName("sourceAmount")
	private SourceAmount sourceAmount;

	@SerializedName("retryAllocationUntilTime")
	private String retryAllocationUntilTime;

	@SerializedName("spendingCategory")
	private String spendingCategory;

	@SerializedName("roundUp")
	private RoundUp roundUp;

	@SerializedName("direction")
	private String direction;

	@SerializedName("updatedAt")
	private String updatedAt;

	@SerializedName("amount")
	private Amount amount;

	@SerializedName("totalFeeAmount")
	private TotalFeeAmount totalFeeAmount;

	@SerializedName("counterPartyUid")
	private String counterPartyUid;

	@SerializedName("counterPartyName")
	private String counterPartyName;

	@SerializedName("counterPartySubEntityIdentifier")
	private String counterPartySubEntityIdentifier;

	@SerializedName("settlementTime")
	private String settlementTime;

	@SerializedName("transactingApplicationUserUid")
	private String transactingApplicationUserUid;

	@SerializedName("counterPartySubEntitySubIdentifier")
	private String counterPartySubEntitySubIdentifier;

	@SerializedName("sourceSubType")
	private String sourceSubType;

	@SerializedName("batchPaymentDetails")
	private BatchPaymentDetails batchPaymentDetails;

	@SerializedName("status")
	private String status;

	public FeedItemsItem(int totalFees, String country, String counterPartyType, String userNote, String counterPartySubEntityUid, String source, String counterPartySubEntityName, String transactionTime, String reference, boolean hasAttachment, int exchangeRate, String feedItemUid, boolean hasReceipt, String categoryUid, SourceAmount sourceAmount, String retryAllocationUntilTime, String spendingCategory, RoundUp roundUp, String direction, String updatedAt, Amount amount, TotalFeeAmount totalFeeAmount, String counterPartyUid, String counterPartyName, String counterPartySubEntityIdentifier, String settlementTime, String transactingApplicationUserUid, String counterPartySubEntitySubIdentifier, String sourceSubType, BatchPaymentDetails batchPaymentDetails, String status) {
		this.totalFees = totalFees;
		this.country = country;
		this.counterPartyType = counterPartyType;
		this.userNote = userNote;
		this.counterPartySubEntityUid = counterPartySubEntityUid;
		this.source = source;
		this.counterPartySubEntityName = counterPartySubEntityName;
		this.transactionTime = transactionTime;
		this.reference = reference;
		this.hasAttachment = hasAttachment;
		this.exchangeRate = exchangeRate;
		this.feedItemUid = feedItemUid;
		this.hasReceipt = hasReceipt;
		this.categoryUid = categoryUid;
		this.sourceAmount = sourceAmount;
		this.retryAllocationUntilTime = retryAllocationUntilTime;
		this.spendingCategory = spendingCategory;
		this.roundUp = roundUp;
		this.direction = direction;
		this.updatedAt = updatedAt;
		this.amount = amount;
		this.totalFeeAmount = totalFeeAmount;
		this.counterPartyUid = counterPartyUid;
		this.counterPartyName = counterPartyName;
		this.counterPartySubEntityIdentifier = counterPartySubEntityIdentifier;
		this.settlementTime = settlementTime;
		this.transactingApplicationUserUid = transactingApplicationUserUid;
		this.counterPartySubEntitySubIdentifier = counterPartySubEntitySubIdentifier;
		this.sourceSubType = sourceSubType;
		this.batchPaymentDetails = batchPaymentDetails;
		this.status = status;
	}

	public FeedItemsItem() {

	}

	protected FeedItemsItem(Parcel in) {
		totalFees = in.readInt();
		country = in.readString();
		counterPartyType = in.readString();
		userNote = in.readString();
		counterPartySubEntityUid = in.readString();
		source = in.readString();
		counterPartySubEntityName = in.readString();
		transactionTime = in.readString();
		reference = in.readString();
		hasAttachment = in.readByte() != 0;
		exchangeRate = in.readInt();
		feedItemUid = in.readString();
		hasReceipt = in.readByte() != 0;
		categoryUid = in.readString();
		sourceAmount = in.readParcelable(SourceAmount.class.getClassLoader());
		retryAllocationUntilTime = in.readString();
		spendingCategory = in.readString();
		roundUp = in.readParcelable(RoundUp.class.getClassLoader());
		direction = in.readString();
		updatedAt = in.readString();
		totalFeeAmount = in.readParcelable(TotalFeeAmount.class.getClassLoader());
		counterPartyUid = in.readString();
		counterPartyName = in.readString();
		counterPartySubEntityIdentifier = in.readString();
		settlementTime = in.readString();
		transactingApplicationUserUid = in.readString();
		counterPartySubEntitySubIdentifier = in.readString();
		sourceSubType = in.readString();
		status = in.readString();
	}

	public static final Creator<FeedItemsItem> CREATOR = new Creator<FeedItemsItem>() {
		@Override
		public FeedItemsItem createFromParcel(Parcel in) {
			return new FeedItemsItem(in);
		}

		@Override
		public FeedItemsItem[] newArray(int size) {
			return new FeedItemsItem[size];
		}
	};

	public int getTotalFees(){
		return totalFees;
	}

	public String getCountry(){
		return country;
	}

	public String getCounterPartyType(){
		return counterPartyType;
	}

	public String getUserNote(){
		return userNote;
	}

	public String getCounterPartySubEntityUid(){
		return counterPartySubEntityUid;
	}

	public String getSource(){
		return source;
	}

	public String getCounterPartySubEntityName(){
		return counterPartySubEntityName;
	}

	public String getTransactionTime(){
		return transactionTime;
	}

	public String getReference(){
		return reference;
	}

	public boolean isHasAttachment(){
		return hasAttachment;
	}

	public int getExchangeRate(){
		return exchangeRate;
	}

	public String getFeedItemUid(){
		return feedItemUid;
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

	public String getRetryAllocationUntilTime(){
		return retryAllocationUntilTime;
	}

	public String getSpendingCategory(){
		return spendingCategory;
	}

	public RoundUp getRoundUp(){
		return roundUp;
	}

	public String getDirection(){
		return direction;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public Amount getAmount(){
		return amount;
	}

	public TotalFeeAmount getTotalFeeAmount(){
		return totalFeeAmount;
	}

	public String getCounterPartyUid(){
		return counterPartyUid;
	}

	public String getCounterPartyName(){
		return counterPartyName;
	}

	public String getCounterPartySubEntityIdentifier(){
		return counterPartySubEntityIdentifier;
	}

	public String getSettlementTime(){
		return settlementTime;
	}

	public String getTransactingApplicationUserUid(){
		return transactingApplicationUserUid;
	}

	public String getCounterPartySubEntitySubIdentifier(){
		return counterPartySubEntitySubIdentifier;
	}

	public String getSourceSubType(){
		return sourceSubType;
	}

	public BatchPaymentDetails getBatchPaymentDetails(){
		return batchPaymentDetails;
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
		parcel.writeInt(totalFees);
		parcel.writeString(country);
		parcel.writeString(counterPartyType);
		parcel.writeString(userNote);
		parcel.writeString(counterPartySubEntityUid);
		parcel.writeString(source);
		parcel.writeString(counterPartySubEntityName);
		parcel.writeString(transactionTime);
		parcel.writeString(reference);
		parcel.writeByte((byte) (hasAttachment ? 1 : 0));
		parcel.writeInt(exchangeRate);
		parcel.writeString(feedItemUid);
		parcel.writeByte((byte) (hasReceipt ? 1 : 0));
		parcel.writeString(categoryUid);
		parcel.writeParcelable(sourceAmount, i);
		parcel.writeString(retryAllocationUntilTime);
		parcel.writeString(spendingCategory);
		parcel.writeParcelable(roundUp, i);
		parcel.writeString(direction);
		parcel.writeString(updatedAt);
		parcel.writeParcelable(totalFeeAmount, i);
		parcel.writeString(counterPartyUid);
		parcel.writeString(counterPartyName);
		parcel.writeString(counterPartySubEntityIdentifier);
		parcel.writeString(settlementTime);
		parcel.writeString(transactingApplicationUserUid);
		parcel.writeString(counterPartySubEntitySubIdentifier);
		parcel.writeString(sourceSubType);
		parcel.writeString(status);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FeedItemsItem that = (FeedItemsItem) o;
		return totalFees == that.totalFees && hasAttachment == that.hasAttachment && exchangeRate == that.exchangeRate && hasReceipt == that.hasReceipt && Objects.equals(country, that.country) && Objects.equals(counterPartyType, that.counterPartyType) && Objects.equals(userNote, that.userNote) && Objects.equals(counterPartySubEntityUid, that.counterPartySubEntityUid) && Objects.equals(source, that.source) && Objects.equals(counterPartySubEntityName, that.counterPartySubEntityName) && Objects.equals(transactionTime, that.transactionTime) && Objects.equals(reference, that.reference) && Objects.equals(feedItemUid, that.feedItemUid) && Objects.equals(categoryUid, that.categoryUid) && Objects.equals(sourceAmount, that.sourceAmount) && Objects.equals(retryAllocationUntilTime, that.retryAllocationUntilTime) && Objects.equals(spendingCategory, that.spendingCategory) && Objects.equals(roundUp, that.roundUp) && Objects.equals(direction, that.direction) && Objects.equals(updatedAt, that.updatedAt) && Objects.equals(amount, that.amount) && Objects.equals(totalFeeAmount, that.totalFeeAmount) && Objects.equals(counterPartyUid, that.counterPartyUid) && Objects.equals(counterPartyName, that.counterPartyName) && Objects.equals(counterPartySubEntityIdentifier, that.counterPartySubEntityIdentifier) && Objects.equals(settlementTime, that.settlementTime) && Objects.equals(transactingApplicationUserUid, that.transactingApplicationUserUid) && Objects.equals(counterPartySubEntitySubIdentifier, that.counterPartySubEntitySubIdentifier) && Objects.equals(sourceSubType, that.sourceSubType) && Objects.equals(batchPaymentDetails, that.batchPaymentDetails) && Objects.equals(status, that.status);
	}

	@Override
	public int hashCode() {
		return Objects.hash(totalFees, country, counterPartyType, userNote, counterPartySubEntityUid, source, counterPartySubEntityName, transactionTime, reference, hasAttachment, exchangeRate, feedItemUid, hasReceipt, categoryUid, sourceAmount, retryAllocationUntilTime, spendingCategory, roundUp, direction, updatedAt, amount, totalFeeAmount, counterPartyUid, counterPartyName, counterPartySubEntityIdentifier, settlementTime, transactingApplicationUserUid, counterPartySubEntitySubIdentifier, sourceSubType, batchPaymentDetails, status);
	}
}