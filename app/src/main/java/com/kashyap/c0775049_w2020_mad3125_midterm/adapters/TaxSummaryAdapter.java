package com.kashyap.c0775049_w2020_mad3125_midterm.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kashyap.c0775049_w2020_mad3125_midterm.R;
import com.kashyap.c0775049_w2020_mad3125_midterm.model.CRACustomer;

public class TaxSummaryAdapter extends RecyclerView.Adapter<TaxSummaryAdapter.TaxSummaryViewHolder>{

    private CRACustomer customer;

    public TaxSummaryAdapter(CRACustomer customer) {
        this.customer = customer;
    }

    @NonNull
    @Override
    public TaxSummaryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tax_summary,parent,false);

        TaxSummaryViewHolder taxSummaryViewHolder = new TaxSummaryViewHolder(mView);
        return taxSummaryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TaxSummaryViewHolder holder, int position) {
        holder.textViewLable.setText(customer.getLables()[position]);
        holder.textViewValue.setText(customer.getContent()[position]);
    }

    @Override
    public int getItemCount() {
        return customer.getLables().length;
    }

    public class TaxSummaryViewHolder extends RecyclerView.ViewHolder{

        TextView textViewLable;
        TextView textViewValue;

        public TaxSummaryViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewLable = itemView.findViewById(R.id.textViewLable);
            textViewValue = itemView.findViewById(R.id.textViewValue);
        }
    }
}
