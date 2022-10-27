package com.example.starlingbankchallenge.model.spaces;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class SavingsGoalsItem implements Parcelable {

	@SerializedName("totalSaved")
	private TotalSaved totalSaved;

	@SerializedName("savingsGoalUid")
	private String savingsGoalUid;

	@SerializedName("sortOrder")
	private int sortOrder;

	@SerializedName("name")
	private String name;

	@SerializedName("savedPercentage")
	private int savedPercentage;

	@SerializedName("target")
	private Target target;

	public SavingsGoalsItem(TotalSaved totalSaved, String savingsGoalUid, int sortOrder, String name, int savedPercentage, Target target) {
		this.totalSaved = totalSaved;
		this.savingsGoalUid = savingsGoalUid;
		this.sortOrder = sortOrder;
		this.name = name;
		this.savedPercentage = savedPercentage;
		this.target = target;
	}

	public SavingsGoalsItem() {
	}

	protected SavingsGoalsItem(Parcel in) {
		totalSaved = in.readParcelable(TotalSaved.class.getClassLoader());
		savingsGoalUid = in.readString();
		sortOrder = in.readInt();
		name = in.readString();
		savedPercentage = in.readInt();
		target = in.readParcelable(Target.class.getClassLoader());
	}

	public static final Creator<SavingsGoalsItem> CREATOR = new Creator<SavingsGoalsItem>() {
		@Override
		public SavingsGoalsItem createFromParcel(Parcel in) {
			return new SavingsGoalsItem(in);
		}

		@Override
		public SavingsGoalsItem[] newArray(int size) {
			return new SavingsGoalsItem[size];
		}
	};

	public TotalSaved getTotalSaved(){
		return totalSaved;
	}

	public String getSavingsGoalUid(){
		return savingsGoalUid;
	}

	public int getSortOrder(){
		return sortOrder;
	}

	public String getName(){
		return name;
	}

	public int getSavedPercentage(){
		return savedPercentage;
	}

	public Target getTarget(){
		return target;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeParcelable(totalSaved, i);
		parcel.writeString(savingsGoalUid);
		parcel.writeInt(sortOrder);
		parcel.writeString(name);
		parcel.writeInt(savedPercentage);
		parcel.writeParcelable(target, i);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SavingsGoalsItem that = (SavingsGoalsItem) o;
		return sortOrder == that.sortOrder && savedPercentage == that.savedPercentage && Objects.equals(totalSaved, that.totalSaved) && Objects.equals(savingsGoalUid, that.savingsGoalUid) && Objects.equals(name, that.name) && Objects.equals(target, that.target);
	}

	@Override
	public int hashCode() {
		return Objects.hash(totalSaved, savingsGoalUid, sortOrder, name, savedPercentage, target);
	}
}