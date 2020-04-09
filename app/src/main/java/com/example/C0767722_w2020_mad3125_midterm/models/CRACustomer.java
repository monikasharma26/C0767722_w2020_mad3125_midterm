package com.example.C0767722_w2020_mad3125_midterm.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.C0767722_w2020_mad3125_midterm.calculations.Calculation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CRACustomer implements Parcelable {
    public String sinNumber;
    private String fName,lName,fullName;
    private String birthDate;
    private String gender;
    private int age;
    private double grossIncome,rrsContributed;
    private double provincialTax,fedralTax,cpp,ei,rrsp,carryForwardRrsp,maxiumRrsp,totalTaxPaid,totalTaxedIncome;


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
        public CRACustomer(){

        }
    public CRACustomer(String sinNumber, String fName, String lName, String birthDate, String gender ,
                       Double grossIncome, Double rrsContributed) {
        this.sinNumber = sinNumber;
        this.fName = fName;
        this.lName = lName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.grossIncome = grossIncome;
        this.rrsContributed = rrsContributed;
    }

    protected CRACustomer(Parcel in) {
        sinNumber = in.readString();
        fName = in.readString();
        lName = in.readString();
        fullName = in.readString();
        birthDate = in.readString();
        age = in.readInt();
        gender = in.readString();
        grossIncome = in.readDouble();
        rrsContributed = in.readDouble();
    }


    public static final Creator<CRACustomer> CREATOR = new Creator<CRACustomer>() {
        @Override
        public CRACustomer createFromParcel(Parcel in) {
            return new CRACustomer(in);
        }

        @Override
        public CRACustomer[] newArray(int size) {
            return new CRACustomer[size];
        }
    };

    public String getSinNumber() {
        return sinNumber;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSinNumber(String sinNumber) {
        this.sinNumber = sinNumber;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }
    public int getAge() {
        return age;
    }


    public String getBirthDate() {
        return birthDate;
    }

    public String getFullName()
    {
        fullName = lName.toUpperCase()+","+fName;
        return fullName;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public double getGrossIncome() {
        return grossIncome;
    }

    public void setGrossIncome(Double grossIncome) {
        this.grossIncome = grossIncome;
    }

    public double getRrsContributed() {
        return rrsContributed;
    }

    public void setRrsContributed(double rrsContributed) {
        this.rrsContributed = rrsContributed;
    }

    public double getProvincialTax() {
        provincialTax = Calculation.calculateProTax(grossIncome);
        return provincialTax;
    }

    public double getFedralTax() {
        fedralTax = Calculation.calculateFedralTax(grossIncome);
        return fedralTax;
    }

    public double getCpp() {
        return cpp = Calculation.calculateCPP(grossIncome);
    }

    public double getEi() {
        return ei  = Calculation.calculateEI(grossIncome);
    }

    public double getMaxiumRrsp() {
        return rrsp = Calculation.calculateMaxRRSP(grossIncome);
    }

    public double getCarryForwardRrsp() {

        return carryForwardRrsp = Calculation.calculateMaxRRSP(grossIncome) - rrsContributed;
    }

    
    public double getTotalTaxPaid() {
        totalTaxPaid = getProvincialTax()+getFedralTax();
        return totalTaxPaid;
    }

    public double getTotalTaxedIncome() {
        double totalamount = getEi()+getCpp()+getMaxiumRrsp();
        totalTaxedIncome =  grossIncome - totalamount;
        return totalTaxedIncome;
    }
    public String taxFilingDate() {
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = dateFormat.format(date);
        return formattedDate.toUpperCase();
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(sinNumber);
        dest.writeString(fName);
        dest.writeString(lName);
        dest.writeString(fullName);
        dest.writeString(birthDate);
        dest.writeInt(age);
        dest.writeString(gender);
        dest.writeDouble(grossIncome);
        dest.writeDouble(rrsContributed);
    }


}

