package com.kashyap.c0775049_w2020_mad3125_midterm;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.kashyap.c0775049_w2020_mad3125_midterm.model.CRACustomer;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;
import java.util.Date;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        //Set title of activity
        setTitle(R.string.mainActivityTitle);

        Calendar calendar = Calendar.getInstance();
        final Integer day = calendar.get(Calendar.DAY_OF_MONTH);
        final Integer month = calendar.get(Calendar.MONTH);
        final Integer year = calendar.get(Calendar.YEAR);


        editTextBirthDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    DatePickerDialog dialog = DatePickerDialog.newInstance(new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
                            Toast.makeText(MainActivity.this, String.valueOf(dayOfMonth), Toast.LENGTH_SHORT).show();
                        }
                    },year,month,day);
                    dialog.show(getFragmentManager(),"");
                }
            }
        });

        CRACustomer tempObj = new CRACustomer("1","Kashyap","jhaveri","male",80000.0,14400.0);

        Toast.makeText(this, String.valueOf(Math.ro), Toast.LENGTH_LONG).show();
    }
}
