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
        double ei;
        if(grossIncome>=53100){
            ei=  53100*0.0162;
        }
        else{
            ei=grossIncome*0.0162;
        }
        return ei;
    }
    public double CalculateCPP(Double grossIncome){
        double cpp;
        if(grossIncome>=57400){
            cpp=  57400*0.051;
        }
        else{
            cpp=grossIncome*0.051;
        }
        return cpp;

    }

}
