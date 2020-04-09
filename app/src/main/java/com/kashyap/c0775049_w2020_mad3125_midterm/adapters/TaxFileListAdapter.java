package com.kashyap.c0775049_w2020_mad3125_midterm.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kashyap.c0775049_w2020_mad3125_midterm.R;
import com.kashyap.c0775049_w2020_mad3125_midterm.ui.TaxSummaryActivity;
import com.kashyap.c0775049_w2020_mad3125_midterm.model.CRACustomer;
import com.kashyap.c0775049_w2020_mad3125_midterm.repo.DataManager;

public class TaxFileListAdapter  extends RecyclerView.Adapter<TaxFileListAdapter.TaxFileListViewHolder> {
    @NonNull
    @Override
    public TaxFileListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tax_file,parent,false);

        TaxFileListViewHolder mTaxFileListViewHolder = new TaxFileListViewHolder(mView);

        return mTaxFileListViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final TaxFileListViewHolder holder, int position) {

        final CRACustomer customer = DataManager.getInstance().getCustomers().get(position);

        holder.textViewSin.setText("SIN: "+customer.getSin());
        holder.textViewFullName.setText("Name: "+customer.getFullName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(holder.itemView.getContext(), TaxSummaryActivity.class);
                mIntent.putExtra("craCustomerOBJ",customer);
                holder.itemView.getContext().startActivity(mIntent);
            }
        });
    }



    @Override
    public int getItemCount() {
        return DataManager.getInstance().getCustomers().size();
    }

    public class TaxFileListViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView textViewFullName;
        TextView textViewSin;

        public TaxFileListViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.imageViewImage);
            textViewFullName = itemView.findViewById(R.id.textViewFullName);
            textViewSin = itemView.findViewById(R.id.textViewSin);
        }
    }
}
