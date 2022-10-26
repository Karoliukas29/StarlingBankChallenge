package com.example.starlingbankchallenge.feature.transactionsroundup.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.starlingbankchallenge.R;
import com.example.starlingbankchallenge.databinding.TransactionsItemBinding;
import com.example.starlingbankchallenge.model.transactions.FeedItemsItem;
import com.example.starlingbankchallenge.utilities.CalculationsHelper;
import com.example.starlingbankchallenge.utilities.NumberFormattedUtil;

import java.text.DecimalFormat;
import java.util.Objects;

public class TransactionsAdapter extends ListAdapter<FeedItemsItem, TransactionsAdapter.TransactionViewHolder> {

    private final Context context;
    private final DecimalFormat decimalFormat = new DecimalFormat("0.00");

    public TransactionsAdapter(Context context) {
        super(DIFF_CALLBACK);
        this.context = context;
    }

    @NonNull
    @Override
    public TransactionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TransactionViewHolder(TransactionsItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull TransactionViewHolder holder, int position) {
        holder.binding.appCompatTvReference.setText(getItem(position).getReference());

        int amountInPennies = getItem(position).getAmount().getMinorUnits();
        double amountWithDecimal = (double) (amountInPennies / 100.0);

        String availableAmountToRoundUpDecimal = decimalFormat.format(CalculationsHelper.
                RoundUpAvailableAmount(amountInPennies));
        holder.binding.appCompatTvAmountToRoundUp.setText("+" + availableAmountToRoundUpDecimal);

        holder.binding.appCompatTvAmount.setText(getItem(position).getAmount().getCurrency() + " " +
                NumberFormattedUtil.currencyWithChosenLocalisation(amountWithDecimal));
        holder.binding.appCompatTvType.setText(context.getString(R.string.fps) + " " + getItem(position).getDirection());
    }

    static class TransactionViewHolder extends RecyclerView.ViewHolder {
        private final TransactionsItemBinding binding;

        public TransactionViewHolder(TransactionsItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @Override
    public int getItemCount() {
        return getCurrentList().size();
    }

    public static final DiffUtil.ItemCallback<FeedItemsItem> DIFF_CALLBACK = new DiffUtil.ItemCallback<>() {

        @Override
        public boolean areItemsTheSame(@NonNull FeedItemsItem oldItem, @NonNull FeedItemsItem newItem) {
            return Objects.equals(oldItem.getCategoryUid(), newItem.getCategoryUid());
        }

        @Override
        public boolean areContentsTheSame(@NonNull FeedItemsItem oldItem, @NonNull FeedItemsItem newItem) {
            return oldItem.equals(newItem);
        }
    };
}