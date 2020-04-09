package com.example.C0767722_w2020_mad3125_midterm.calculations;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

//Perform all tax calculations
public class Calculation {


    public double CalculateEI(double grossIncome) {
        double ei;
        if (grossIncome >= 53100) {
            ei = 53100 * 0.0162;
        } else {
            ei = grossIncome * 0.0162;
        }
        return ei;
    }

    public double CalculateCPP(double grossIncome) {
        double cpp;
        if (grossIncome >= 57400) {
            cpp = 57400 * 0.051;
        } else {
            cpp = grossIncome * 0.051;
        }
        return cpp;
    }

    public double calculateRRSP(double grossIncome) {
        double maxRRSP;
        maxRRSP = grossIncome * 0.18;
        return maxRRSP;
    }

    public double calculateProTax(double taxableIncome) {
        double currenttax = 0;
        double proviencetax = 0;
        double taxIncome = taxableIncome;
        if (taxIncome > 10582) {
            taxIncome = taxIncome - 10582;
            //create slabs like 43906-10582.01 = 33323.99
            if (taxIncome > 33323.99) {
                currenttax = 33323.99;
            } else {
                currenttax = taxIncome;
            }
            currenttax = currenttax * 0.0505;
            proviencetax = proviencetax + currenttax;
            //create slabs like 43906-10582.01 = 33323.99
            if (taxIncome > 33323.99) {
                taxIncome = taxIncome - 33323.99;
                if (taxIncome > 43906.99) {
                    currenttax = 43906.99;

                } else {
                    currenttax = taxIncome;
                }
                currenttax = currenttax * 0.0915;

                proviencetax = proviencetax + currenttax;

                if (taxIncome > 43906.99) {
                    taxIncome = taxIncome - 43906.99;
                    if (taxIncome > 62186.99) {
                        currenttax = 62186.99;
                    } else {
                        currenttax = taxIncome;
                    }
                    currenttax = currenttax * 0.1116;
                    proviencetax = proviencetax + currenttax;

                    if (taxIncome > 62186.99) {
                        taxIncome = taxIncome - 62186.99;
                        if (taxIncome > 69999.99) {
                            currenttax = 69999.99;
                        } else {
                            currenttax = taxIncome;
                        }
                        currenttax = currenttax * 0.1216;
                        proviencetax = proviencetax + currenttax;

                        if (taxIncome > 69999.99) {
                            taxIncome = taxIncome - 69999.99;
                            currenttax = taxIncome;
                            currenttax = currenttax * 0.1316;
                            proviencetax = proviencetax + currenttax;
                        }
                    }
                }
            }
        }
        else {
            Log.d("Income", "TotalTaxableIncome is less Than 10582");
        }
        return proviencetax;
    }
    public double calculateFedralTax(double taxableIncome)
    {
        double cuurentTax=0;
        double fedralTax=0;
        double taxincome=taxableIncome;
        if (taxincome>12069)
        {
            taxincome=taxincome-12069;
            if(taxincome>35561) {
                cuurentTax=35561;
            }
            else{
                cuurentTax=taxincome;
            }
            cuurentTax=cuurentTax*0.15;
            fedralTax=fedralTax+cuurentTax;
            if(taxincome>35561)
            {
                taxincome=taxincome-35561;
                if(taxincome>47628.99)
                {
                    cuurentTax=47628.99;
                }
                else {
                    cuurentTax=taxincome;
                }
                cuurentTax=cuurentTax*0.205;
                fedralTax=fedralTax+cuurentTax;
                if(taxincome>47628.99)
                {
                    taxincome = taxincome-47628.99;
                    if(taxincome>52407.99){
                        cuurentTax=52407.99;
                    }
                    else{
                        cuurentTax=taxincome;
                    }
                    cuurentTax=cuurentTax*0.26;
                    fedralTax=fedralTax+cuurentTax;

                    if (taxincome > 52407.99)
                    {
                        taxincome = taxincome-52407.99;
                        if(taxincome>62703.99){
                            cuurentTax=62703.99;
                        }
                        else{
                            cuurentTax=taxincome;
                        }
                        cuurentTax=cuurentTax*0.29;
                        fedralTax=+fedralTax+cuurentTax;
                        if (taxincome > 62703.99)
                        {
                            taxincome = taxincome-62703.99;
                            cuurentTax=taxincome;
                            cuurentTax=cuurentTax*0.33;
                            fedralTax=+fedralTax+cuurentTax;
                        }
                    }

                }
            }
        }
        else
        {
           Log.d("Tax","TotalTaxableIncome is less Than 12069");
        }
        return fedralTax;

    }
}

