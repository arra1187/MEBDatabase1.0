package com.example.mebdatabase10;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class UpgradeViewHolder extends RecyclerView.ViewHolder {
    //private final TextView upgradeItemView;

    private UpgradeViewHolder(View itemView)
    {
        super(itemView);
        //upgradeItemView = itemView.findViewById(R.id.textView);
    }

    public void bind(int text)
    {
        //upgradeItemView.setText(text);
    }

    static UpgradeViewHolder create(ViewGroup parent) {
        //View view = LayoutInflater.from(parent.getContext())
               // .inflate(R.layout.recyclerview_item, parent, false);
        //return new UpgradeViewHolder(view);
        return null;
    }
}
