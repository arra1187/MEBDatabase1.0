package com.example.mebdatabase10;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class UpgradeListAdapter extends ListAdapter<Upgrade, UpgradeViewHolder>
{
    public UpgradeListAdapter(@NonNull DiffUtil.ItemCallback<Upgrade> diffCallback)
    {
        super(diffCallback);
    }

    @Override
    public UpgradeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return UpgradeViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(UpgradeViewHolder holder, int position) {
        Upgrade current = getItem(position);
        holder.bind(current.getUpgradeCost());
    }
}
