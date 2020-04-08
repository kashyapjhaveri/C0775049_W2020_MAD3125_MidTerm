package com.kashyap.c0775049_w2020_mad3125_midterm;

import android.os.Bundle;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.editTextSin) TextInputEditText editTextSin;
    @InjectView(R.id.editTextFirstName) TextInputEditText editTextFirstName;
    @InjectView(R.id.editTextLastName) TextInputEditText editTextLastName;
    @InjectView(R.id.editTextBirthDate) TextInputEditText editTextBirthDate;
    @InjectView(R.id.rgGender) RadioGroup rgGender;
    @InjectView(R.id.editTextGrossIncome) TextInputEditText editTextGrossIncome;
    @InjectView(R.id.editTextRrsp) TextInputEditText editTextRrsp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        //Set title of activity
        setTitle(R.string.mainActivityTitle);

        

    }
}
