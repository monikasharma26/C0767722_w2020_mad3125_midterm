package com.example.C0767722_w2020_mad3125_midterm.Activities;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.C0767722_w2020_mad3125_midterm.R;
import com.example.C0767722_w2020_mad3125_midterm.calculations.Calculation;
import com.example.C0767722_w2020_mad3125_midterm.models.CRACustomer;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.textfield.TextInputEditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.txtSinNo)
    TextInputEditText txtSinNo;
    @InjectView(R.id.txtFName)
    TextInputEditText txtFName;
    @InjectView(R.id.txtLName)
    TextInputEditText txtLName;
    @InjectView(R.id.txtDOB)
    TextInputEditText txtDOB;
    @InjectView(R.id.txtAge)
    TextInputEditText txtAge;
    @InjectView(R.id.radioFullTime)
    MaterialRadioButton radioMale;
    @InjectView(R.id.radioPartTime)
    MaterialRadioButton radioFemale;
    @InjectView(R.id.radioTrainee)
    MaterialRadioButton radioOthers;
    @InjectView(R.id.radioGroup)
    RadioGroup radioGroup;
    @InjectView(R.id.txtGrossIncome)
    TextInputEditText txtGrossIncome;
    @InjectView(R.id.txtRRSPCont)
    TextInputEditText txtRRSPCont;
    @InjectView(R.id.btnCalculate)
    MaterialButton btnCalculate;
    private DatePickerDialog datePicker;
    private RadioButton radioType;
    private int age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        int selectedId = radioGroup.getCheckedRadioButtonId();
        radioType =  findViewById(selectedId);
        txtDOB.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    closeKeyboard();
                    openDatePicker();
                }
            }
        });
        txtDOB.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           openDatePicker();
                                       }
    });

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendButtonClicked();
            }
        });

    }
    private void openDatePicker() {
        final Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        final int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        datePicker = new DatePickerDialog(MainActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(year, monthOfYear, dayOfMonth);
                        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
                        String strDate = format.format(calendar.getTime());

                        txtDOB.setText(strDate.toUpperCase());
                        int currentYear = calendar.getInstance().get(Calendar.YEAR);
                       // Log.d("dsad", String.valueOf(currentYear));
                        age = currentYear -year;

                    }
                }, year, month, day);
        datePicker.getDatePicker().setMaxDate(new Date().getTime());
        datePicker.show();

    }
    private void closeKeyboard() {
        InputMethodManager inputManager = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    private void sendButtonClicked() {
        int sinNumber = Integer.valueOf(txtSinNo.getText().toString());
        String fName = txtFName.getText().toString();
        String lName = txtLName.getText().toString();
        String dob = txtDOB.getText().toString();
        String gender = radioType.getText().toString();
        String grossIncome = txtGrossIncome.getText().toString();
        String rrspContributed = txtRRSPCont.getText().toString();
        CRACustomer  craCustomer = new CRACustomer(sinNumber,fName,lName,dob,gender,grossIncome,rrspContributed);

        Intent intent = new Intent(this, CRACalulationDetailActivity.class);
        intent.putExtra("details",craCustomer);
        startActivity(intent);
    }
   

}
