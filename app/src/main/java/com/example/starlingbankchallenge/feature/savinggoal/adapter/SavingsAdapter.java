package com.example.starlingbankchallenge.feature.savinggoal.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.example.starlingbankchallenge.databinding.SavingsItemBinding;
import com.example.starlingbankchallenge.model.spaces.SavingsGoalsItem;

import java.text.DecimalFormat;
import java.util.Objects;

public class SavingsAdapter extends ListAdapter<SavingsGoalsItem, SavingsAdapter.SavingsViewHolder> {

    private final Context context;

    public SavingsAdapter(Context context) {
        super(DIFF_CALLBACK);
        this.context = context;
    }

    @NonNull
    @Override
    public SavingsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SavingsViewHolder(SavingsItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull SavingsViewHolder holder, int position) {
        holder.binding.appCompatTvSavingsName.setText(getItem(position).getName());
        holder.binding.appCompatTvSavedAmount.setText("Saved amount: " + String.valueOf(getItem(position).getTotalSaved().getMinorUnits()));
        holder.binding.appCompatTvTargetToSave.setText("Goal: " + String.valueOf(getItem(position).getTarget().getMinorUnits()));
    }

    static class SavingsViewHolder extends RecyclerView.ViewHolder {
        private final SavingsItemBinding binding;

        public SavingsViewHolder(SavingsItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @Override
    public int getItemCount() {
        return getCurrentList().size();
    }

    public static final DiffUtil.ItemCallback<SavingsGoalsItem> DIFF_CALLBACK = new DiffUtil.ItemCallback<>() {

        @Override
        public boolean areItemsTheSame(@NonNull SavingsGoalsItem oldItem, @NonNull SavingsGoalsItem newItem) {
            return Objects.equals(oldItem.getSavingsGoalUid(), newItem.getSavingsGoalUid());
        }

        @Override
        public boolean areContentsTheSame(@NonNull SavingsGoalsItem oldItem, @NonNull SavingsGoalsItem newItem) {
            return oldItem.equals(newItem);
        }
    };
}
