package com.example.database.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.database.R;
import com.example.database.databinding.FragmentOpenItemsBinding;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;


public class OpenItemsFrag extends Fragment {


    FragmentOpenItemsBinding binding;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_open_items, container, false);


        binding.textView3.setText(getArguments().getString("title"));
        binding.textView4.setText(getArguments().getString("text"));

        return binding.getRoot();
    }

}
