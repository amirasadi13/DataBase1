package com.example.database.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.database.R;
import com.example.database.database.NoteDao;
import com.example.database.database.NoteDataBase_Impl;
import com.example.database.databinding.FragmentListNoteBinding;


public class ListNoteFrag extends Fragment {

    FragmentListNoteBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment





        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_list_note, container, false);

        binding.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_listNoteFrag_to_enterNoteFrag);
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        binding.recyclerView.setLayoutManager(linearLayoutManager);




        return binding.getRoot();
    }


}
