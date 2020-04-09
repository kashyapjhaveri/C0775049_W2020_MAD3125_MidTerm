package com.kashyap.c0775049_w2020_mad3125_midterm.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.kashyap.c0775049_w2020_mad3125_midterm.R;
import com.kashyap.c0775049_w2020_mad3125_midterm.adapters.TaxFileListAdapter;
import com.kashyap.c0775049_w2020_mad3125_midterm.adapters.TaxSummaryAdapter;
import com.kashyap.c0775049_w2020_mad3125_midterm.model.CRACustomer;

public class TaxSummaryActivity extends AppCompatActivity {

    RecyclerView rvTaxFileList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tax_summary);

        CRACustomer customer = (CRACustomer) getIntent().getSerializableExtra("craCustomerOBJ");

        rvTaxFileList = findViewById(R.id.rvTaxFileList);

        RecyclerView.LayoutManager linerLayoutManage = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        TaxSummaryAdapter taxSummaryAdapter = new TaxSummaryAdapter(customer);

        rvTaxFileList.setLayoutManager(linerLayoutManage);
        rvTaxFileList.setAdapter(taxSummaryAdapter);

    }
}
