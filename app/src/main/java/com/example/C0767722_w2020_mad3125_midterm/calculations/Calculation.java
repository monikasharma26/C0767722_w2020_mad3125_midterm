package com.example.C0767722_w2020_mad3125_midterm.calculations;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

//Perform all tax calculations
public class Calculation {


    public double CalculateEI(Double grossIncome){
        double EI;
        if(grossIncome>=53100){
            EI=  53100*0.0162;
        }
        else{
            EI=grossIncome*0.0162;
        }
        return EI;

    }

}
