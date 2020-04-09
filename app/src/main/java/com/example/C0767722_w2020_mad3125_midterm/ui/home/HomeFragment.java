package com.example.C0767722_w2020_mad3125_midterm.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.C0767722_w2020_mad3125_midterm.Activities.CRACalulationDetailActivity;
import com.example.C0767722_w2020_mad3125_midterm.R;
import com.example.C0767722_w2020_mad3125_midterm.models.CRACustomer;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    CRACustomer craCustomer;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
       Bundle s  =  ((CRACalulationDetailActivity)getContext()).getData().getBundle("data");
       craCustomer =s.getParcelable("data");

      // String s = craCustomer.getfName().toLowerCase().toString();
       Log.d("hhas",craCustomer.getFullName());
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
