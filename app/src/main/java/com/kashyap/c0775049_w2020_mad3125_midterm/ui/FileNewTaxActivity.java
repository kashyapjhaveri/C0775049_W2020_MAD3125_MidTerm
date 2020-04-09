package com.kashyap.c0775049_w2020_mad3125_midterm.ui;

import android.icu.util.DateInterval;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.kashyap.c0775049_w2020_mad3125_midterm.R;
import com.kashyap.c0775049_w2020_mad3125_midterm.model.CRACustomer;
import com.kashyap.c0775049_w2020_mad3125_midterm.repo.DataManager;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class FileNewTaxActivity extends AppCompatActivity {

    @InjectView(R.id.editTextSin)
    TextInputEditText editTextSin;
    @InjectView(R.id.editTextFirstName)
    TextInputEditText editTextFirstName;
    @InjectView(R.id.editTextLastName)
    TextInputEditText editTextLastName;
    @InjectView(R.id.editTextBirthDate)
    TextInputEditText editTextBirthDate;
    @InjectView(R.id.rgGender)
    RadioGroup rgGender;
    @InjectView(R.id.editTextGrossIncome)
    TextInputEditText editTextGrossIncome;
    @InjectView(R.id.editTextRrsp)
    TextInputEditText editTextRrsp;
    @InjectView(R.id.textFieldBirthDate)
    TextInputLayout textFieldBirthDate;

    Date tempDate;
    @InjectView(R.id.textFieldRrsp)
    TextInputLayout textFieldRrsp;

    Integer age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        //Set title of activity
        setTitle(R.string.mainActivityTitle);

        final Calendar calendar = Calendar.getInstance();

        final Integer day = calendar.get(Calendar.DAY_OF_MONTH);
        final Integer month = calendar.get(Calendar.MONTH);
        final Integer year = calendar.get(Calendar.YEAR);


        editTextBirthDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    DatePickerDialog dialog = DatePickerDialog.newInstance(new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
                            calendar.set(year, month, dayOfMonth);
                            editTextBirthDate.setText(new SimpleDateFormat("dd-MMM-yyyy").format(calendar.getTime()).toUpperCase());
                        }
                    }, year, month, day);
                    dialog.show(getFragmentManager(), "");
                }
                else
                {
                    age = Calendar.getInstance().get(Calendar.YEAR) - calendar.get(Calendar.YEAR);
                    if (age < 18){
                        editTextBirthDate.setError("Age cannot be <18");
                        editTextBirthDate.setText(null);
                        age = 0;
                    }
                    else{
                        editTextBirthDate.setError(null);
                    }
                }
            }
        });


        editTextGrossIncome.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!editTextGrossIncome.getText().toString().isEmpty()) {
                    Double grossIncome = Double.valueOf(editTextGrossIncome.getText().toString());
                    textFieldRrsp.setHelperText("Maximum amount:- " + grossIncome * 0.18);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        editTextRrsp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!editTextRrsp.getText().toString().isEmpty()) {
                    Double maxAmount = Double.valueOf(editTextGrossIncome.getText().toString()) * 0.18;
                    if (Double.valueOf(editTextRrsp.getText().toString()) > maxAmount){
                        editTextRrsp.setError("Amount cannot exceed "+ maxAmount);
                        editTextRrsp.setText(null);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_file_ne_return, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnu_Save:
                if (editTextSin.getText().toString().isEmpty()) {
                    editTextSin.setError("SIN cannot be empty");
                } else if (editTextSin.getText().toString().length() != 9) {
                    editTextSin.setError("SIN is of 9 numbers");
                } else if (editTextFirstName.getText().toString().isEmpty()) {
                    editTextFirstName.setError("First name cannot be empty");
                } else if (editTextLastName.getText().toString().isEmpty()) {
                    editTextLastName.setError("Last name cannot be empty");
                } else if (editTextBirthDate.getText().toString().isEmpty()) {
                    editTextBirthDate.setError("Birth date cannot be empty");
                } else if (rgGender.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "Please select gender", Toast.LENGTH_SHORT).show();
                } else if (editTextGrossIncome.getText().toString().isEmpty()) {
                    editTextGrossIncome.setError("Gross income cannot be empty");
                } else {
                    CRACustomer tempObj = new CRACustomer(editTextSin.getText().toString(), editTextFirstName.getText().toString(), editTextLastName.getText().toString(), editTextBirthDate.getText().toString(), age,((RadioButton) findViewById(rgGender.getCheckedRadioButtonId())).getText().toString(), Double.valueOf(editTextGrossIncome.getText().toString()), Double.valueOf(editTextRrsp.getText().toString()));
//                    Toast.makeText(this, String.valueOf(tempObj.getProvincialTax()), Toast.LENGTH_SHORT).show();
                    DataManager.getInstance().addCustomer(tempObj);
                    finish();
                }
            break;
        }


        return super.onOptionsItemSelected(item);
    }
}
