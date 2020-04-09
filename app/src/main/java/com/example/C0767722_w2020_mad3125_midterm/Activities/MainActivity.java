package com.example.C0767722_w2020_mad3125_midterm.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.example.C0767722_w2020_mad3125_midterm.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.textfield.TextInputEditText;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
       
    }
}
