package com.example.C0767722_w2020_mad3125_midterm.Activities;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
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
import androidx.appcompat.app.AlertDialog;
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
    private int age, currentYear, yearDOB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        int selectedId = radioGroup.getCheckedRadioButtonId();
        radioType = findViewById(selectedId);
        txtDOB.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    closeKeyboard();
                    openDatePicker();
                } else {
                    checkEligibleAgeforTax();
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
                        yearDOB = year;
                        txtDOB.setText(strDate.toUpperCase());
                        currentYear = calendar.getInstance().get(Calendar.YEAR);
                        // Log.d("dsad", String.valueOf(currentYear));
                        age = currentYear - year;
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
        String sinNumber = txtSinNo.getText().toString();
        String fName = txtFName.getText().toString();
        String lName = txtLName.getText().toString();
        String dob = txtDOB.getText().toString();
        String gender = radioType.getText().toString();
        checkEligibleAgeforTax();
        if (txtSinNo.getText().toString().length() != 9) {
            showAlert("SIN must be  of 9 digits.");
        } else if (fName.trim().isEmpty()) {
            showAlert("Please enter First Name");
        } else if (lName.trim().isEmpty()) {
            showAlert("Please enter Last Name");
        } else if (dob.trim().isEmpty()) {
            showAlert("Please Select Date of birth");
        } else if (txtDOB.getError() != null) {
            showAlert(txtDOB.getError().toString());
        } else if (txtGrossIncome.getText().toString().isEmpty()) {
            showAlert("Please enter Gross Income");
        } else if (txtRRSPCont.getText().toString().trim().isEmpty()) {
            showAlert("Please enter RRSP contribution");
        }
        else{
            Intent intent = new Intent(this, CRADetailsActivity.class);
            CRACustomer craCustomer = new CRACustomer();
            //Log.d("Sinnn", txtGrossIncome.getText().toString());
            craCustomer.setSinNumber(sinNumber);
            craCustomer.setfName(txtFName.getText().toString());
            craCustomer.setlName(txtLName.getText().toString());
            craCustomer.setBirthDate(txtDOB.getText().toString());
            craCustomer.setGrossIncome(Double.parseDouble(txtGrossIncome.getText().toString()));
            craCustomer.setRrsContributed(Double.parseDouble(txtRRSPCont.getText().toString()));
            craCustomer.setGender(gender);
            //       Log.d("tetst1",String.valueOf(age));
            craCustomer.setAge(Integer.toString(age));
            intent.putExtra("details", craCustomer);
            startActivity(intent);
        }

    }
    private void checkEligibleAgeforTax() {
        if(txtDOB.getText().toString().length()!=0) {
            txtAge.setText("Age " + age);
            if (age < 18) {
             //   txtDOB.setTextColor(getResources().getColor(R.color.colorerror));
              //  txtDOB.setTypeface(null, Typeface.BOLD_ITALIC);
                String message = "Not eligible to file tax for current year 2020";
                 txtDOB.setError(message);
            } else {
                txtDOB.setError(null);
            }
        }

    }
    private void showAlert(String message) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Alert!");
        alertDialogBuilder.setMessage(message);
        alertDialogBuilder.setIcon(R.drawable.ic_action_alerts);
        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialogBuilder.setNegativeButton("Cancel ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }
}