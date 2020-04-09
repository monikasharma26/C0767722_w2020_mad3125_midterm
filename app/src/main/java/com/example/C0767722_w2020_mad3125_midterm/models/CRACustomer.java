package com.example.C0767722_w2020_mad3125_midterm.models;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class CRACustomer implements Parcelable {
    private int sinNumber;
    private String fName,lName,fullName;
    private String birthDate;
    private String gender;
    private int age;
    private String grossIncome,rrsContributed;
    private double provincialTax,fedralTax,cpp,ei,rrsp,carryForwardRrsp,maxiumRrsp,totalTaxPaid,totalTaxedIncome;


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
        public CRACustomer(){

        }
    public CRACustomer(int sinNumber, String fName, String lName, String birthDate, String gender ,
                       String grossIncome, String rrsContributed) {
        this.sinNumber = sinNumber;
        this.fName = fName;
        this.lName = lName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.grossIncome = grossIncome;
        this.rrsContributed = rrsContributed;
    }

    protected CRACustomer(Parcel in) {
        sinNumber = in.readInt();
        fName = in.readString();
        lName = in.readString();
        fullName = in.readString();
        birthDate = in.readString();
        age = in.readInt();
        gender = in.readString();
        grossIncome = in.readString();
        rrsContributed = in.readString();
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

    public int getSinNumber() {
        return sinNumber;
    }

    public void setAge(int age) {
        this.age = age;
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

    public String getFullName()
    {
        fullName = lName.toUpperCase()+","+fName;
        return fullName;
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



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(sinNumber);
        dest.writeString(fName);
        dest.writeString(lName);
        dest.writeString(fullName);
        dest.writeString(birthDate);
        dest.writeInt(age);
        dest.writeString(gender);
        dest.writeString(grossIncome);
        dest.writeString(rrsContributed);
    }
}
