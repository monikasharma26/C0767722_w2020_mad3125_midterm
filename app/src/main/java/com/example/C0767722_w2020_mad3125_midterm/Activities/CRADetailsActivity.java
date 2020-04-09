package com.example.C0767722_w2020_mad3125_midterm.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.C0767722_w2020_mad3125_midterm.R;
import com.example.C0767722_w2020_mad3125_midterm.models.CRACustomer;

import java.text.NumberFormat;
import java.util.Locale;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class CRADetailsActivity extends AppCompatActivity {


    NumberFormat numberFormat = NumberFormat.getInstance(Locale.CANADA);
    @InjectView(R.id.txtSin)
    TextView txtSin;
    @InjectView(R.id.txtFullName)
    TextView txtFullName;
    @InjectView(R.id.txtDOB)
    TextView txtDOB;
    @InjectView(R.id.txtAge)
    TextView txtAge;
    @InjectView(R.id.txtGender)
    TextView txtGender;
    @InjectView(R.id.txtTaxFillingdate)
    TextView txtTaxFillingdate;
    @InjectView(R.id.txtGrossIncome)
    TextView txtGrossIncome;
    @InjectView(R.id.txtCPP)
    TextView txtCPP;
    @InjectView(R.id.txtEI)
    TextView txtEI;
    @InjectView(R.id.txtRSSC)
    TextView txtRSSC;
    @InjectView(R.id.txtRSSPMax)
    TextView txtRSSPMax;
    @InjectView(R.id.txtCaryForward)
    TextView txtCaryForward;
    @InjectView(R.id.txtotalTaxableIn)
    TextView txtotalTaxableIn;
    @InjectView(R.id.txtFedTax)
    TextView txtFedTax;
    @InjectView(R.id.txtProTax)
    TextView txtProTax;
    @InjectView(R.id.txtTotalTaxP)
    TextView txtTotalTaxP;

    //  Calendar myCalendar = Calendar.getInstance();
    //String taxFillingDate=numberFormat.format(myCalendar.getTime());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cra_details);
        ButterKnife.inject(this);
        Intent intent = getIntent();
        CRACustomer details = intent.getParcelableExtra("details");

        txtSin.setText(details.getSinNumber());
        txtFullName.setText(details.getFullName());
        txtGender.setText(details.getGender());
        txtDOB.setText(details.getBirthDate());
    //        txtAge.setText(details.getAge());
        txtTaxFillingdate.setText(details.taxFilingDate());
        txtGrossIncome.setText("$" + String.valueOf(numberFormat.format(details.getGrossIncome())));
        txtFedTax.setText("$" + String.valueOf(numberFormat.format(details.getFedralTax())));
        txtProTax.setText("$" + String.valueOf(numberFormat.format(details.getProvincialTax())));
        txtRSSC.setText(String.valueOf("$" + String.valueOf(numberFormat.format(details.getRrsContributed()))));
        txtRSSPMax.setText(String.valueOf("$" + numberFormat.format(details.getMaxiumRrsp())));
        txtCPP.setText(String.valueOf("$" + numberFormat.format(details.getCpp())));
        txtEI.setText(String.valueOf("$" + numberFormat.format(details.getEi())));
        txtCaryForward.setText(String.valueOf("$" + numberFormat.format(details.getCarryForwardRrsp())));
        txtotalTaxableIn.setText("$" + String.valueOf(numberFormat.format(details.getTotalTaxedIncome())));
        txtTotalTaxP.setText(String.valueOf("$" + numberFormat.format(details.getTotalTaxPaid())));
        // Log.d("SInnumber",details.getGrossIncome());
        // txtGrossIncome.setText(String.valueOf(numberFormat.format(details.getGrossIncome())));

        //txtRRSP.setText((int) details.getRrsContributed());


    }
}
