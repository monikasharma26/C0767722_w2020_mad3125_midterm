package com.example.C0767722_w2020_mad3125_midterm.models;

import android.os.Parcel;
import android.os.Parcelable;

public class CRACustomer  {
    private int sinNumber;
    private String fName,lName,fullName;
    private String birthDate,age;
    private String grossIncome;
    private String rrsContributed;
    
    public CRACustomer(int sinNumber, String fName, String lName, String birthDate, String grossIncome, String rrsContributed) {
        this.sinNumber = sinNumber;
        this.fName = fName;
        this.lName = lName;
        this.birthDate = birthDate;
        this.grossIncome = grossIncome;
        this.rrsContributed = rrsContributed;
    }

    protected CRACustomer(Parcel in) {
        sinNumber = in.readInt();
        fName = in.readString();
        lName = in.readString();
        fullName = in.readString();
        birthDate = in.readString();
        age = in.readString();
        grossIncome = in.readString();
        rrsContributed = in.readString();
    }




    public int getSinNumber() {
        return sinNumber;
    }

    public void setSinNumber(int sinNumber) {
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGrossIncome() {
        return grossIncome;
    }

    public void setGrossIncome(String grossIncome) {
        this.grossIncome = grossIncome;
    }

    public String getRrsContributed() {
        return rrsContributed;
    }

    public void setRrsContributed(String rrsContributed) {
        this.rrsContributed = rrsContributed;
    }


}
