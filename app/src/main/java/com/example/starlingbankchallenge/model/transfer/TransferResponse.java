package com.example.starlingbankchallenge.model.transfer;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class TransferResponse implements Parcelable {

	@SerializedName("transferUid")
	private String transferUid;

	@SerializedName("success")
	private boolean success;

	@SerializedName("errors")
	private List<ErrorsItem> errors;

	protected TransferResponse(Parcel in) {
		transferUid = in.readString();
		success = in.readByte() != 0;
		errors = in.createTypedArrayList(ErrorsItem.CREATOR);
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(transferUid);
		dest.writeByte((byte) (success ? 1 : 0));
		dest.writeTypedList(errors);
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public static final Creator<TransferResponse> CREATOR = new Creator<TransferResponse>() {
		@Override
		public TransferResponse createFromParcel(Parcel in) {
			return new TransferResponse(in);
		}

		@Override
		public TransferResponse[] newArray(int size) {
			return new TransferResponse[size];
		}
	};

	public String getTransferUid(){
		return transferUid;
	}

	public boolean isSuccess(){
		return success;
	}

	public List<ErrorsItem> getErrors(){
		return errors;
	}

}