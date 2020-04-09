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


    public static double calculateEI(double grossIncome) {
        double ei;
        if (grossIncome >= 53100) {
            ei = 53100 * 0.0162;
        } else {
            ei = grossIncome * 0.0162;
        }
        return ei;
    }

    public static double calculateCPP(double grossIncome) {
        double cpp;
        if (grossIncome >= 57400) {
            cpp = 57400 * 0.051;
        } else {
            cpp = grossIncome * 0.051;
        }
        return cpp;
    }

    public static double calculateMaxRRSP(double grossIncome) {
        double maxRRSP;
        maxRRSP = grossIncome * 0.18;
        return maxRRSP;
    }

    public static double calculateProTax(double taxableIncome) {
        double proviencetax = 0;
        double taxIncome = taxableIncome;
        if (taxIncome > 10582) {
            taxIncome = taxIncome - 10582;
            proviencetax=0;
            //create slabs like 43906-10582.01 = 33323.99
            if (taxIncome > 43906) {
                proviencetax += 33323.99 * 0.05;
                taxIncome = taxIncome - 33323.99;
                //create slabs like 43906-10582.01 = 33323.99
                if (taxIncome > 87813) {
                    taxIncome = taxIncome - 43906.99;
                    proviencetax += 43906.99 * 0.0915;
                    if (taxIncome > 150000) {
                        taxIncome = taxIncome - 62186.99;
                        proviencetax += 62186.99 * 0.1116;
                        if (taxIncome > 220000) {
                            taxIncome = taxIncome - 69999.99;
                            proviencetax += 69999.99 * 0.1216;
                            if (taxIncome > 220000.01) {
                                proviencetax += taxIncome * 0.1316;
                            }
                        } else {
                            proviencetax = taxIncome * 0.1216;
                        }
                    } else {
                        proviencetax = taxIncome * 0.1116;
                    }
                } else {
                    proviencetax = taxIncome * 0.0915;
                }
            } else{
                        proviencetax = taxIncome * 0.05;
                    }
        }
        else {
            Log.d("Income", "TotalTaxableIncome is less Than 10582");
        }
        return proviencetax;
    }
    public static double calculateFedralTax(double taxableIncome) {
        double cuurentTax = 0;
        double fedralTax = 0;
        double taxincome = taxableIncome;
        if (taxincome > 12069) {
            taxincome = taxincome - 12069;
            fedralTax = 0;
            if (taxincome > 47630) {
                fedralTax += 35561 * 0.15;
                taxincome = taxincome - 35561;
                if (taxincome > 95259) {
                    fedralTax += 47628.99 * 0.205;
                    taxincome = taxincome - 47628.99;
                    if (taxincome > 147667) {
                        fedralTax += 52407.99 * 0.26;
                        taxincome = taxincome - 52407.99;
                        if (taxincome > 210371) {
                            fedralTax += 62703.99 * 0.29;
                            taxincome = taxincome - 62703.99;
                            if (taxincome > 210371.01) {
                                fedralTax += taxincome * 0.33;
                            }
                    } else {
                        fedralTax += taxincome * 0.29;
                    }
                } else {
                    fedralTax += taxincome * 0.26;
                }
            } else {
                fedralTax += taxincome * 0.205;
            }
        } else {
            fedralTax += taxincome * 0.15;
        }
    }

        else
        {
           Log.d("Tax","TotalTaxableIncome is less Than 12069");
        }
        return fedralTax;

    }
}

