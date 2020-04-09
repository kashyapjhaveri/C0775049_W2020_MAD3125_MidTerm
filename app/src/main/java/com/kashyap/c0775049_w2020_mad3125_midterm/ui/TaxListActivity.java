package com.kashyap.c0775049_w2020_mad3125_midterm.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.kashyap.c0775049_w2020_mad3125_midterm.R;
import com.kashyap.c0775049_w2020_mad3125_midterm.adapters.TaxFileListAdapter;

public class TaxListActivity extends AppCompatActivity {

    RecyclerView recyclerViewTaxList;


    private void fillData(){
        TaxFileListAdapter taxFileListAdapter = new TaxFileListAdapter();
        RecyclerView.LayoutManager linerLayoutManager = new LinearLayoutManager(this);

        recyclerViewTaxList.setLayoutManager(linerLayoutManager);
        recyclerViewTaxList.setAdapter(taxFileListAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tax_list);

        setTitle(R.string.taxListActivityTile);
        recyclerViewTaxList = findViewById(R.id.rvTaxList);

        fillData();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        fillData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tax_list, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnu_file_new_tax:
                Intent mIntent = new Intent(this,FileNewTaxActivity.class);
                startActivity(mIntent);
            break;
        }
        return super.onOptionsItemSelected(item);
    }
}
