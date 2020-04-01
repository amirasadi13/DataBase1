package com.example.database.fragment;


import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.database.R;
import com.example.database.database.Note;
import com.example.database.database.NoteDao;
import com.example.database.database.NoteDataBase;
import com.example.database.databinding.FragmentEnterNoteBinding;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;


public class EnterNoteFrag extends Fragment {


    FragmentEnterNoteBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_enter_note, container, false);



        binding.button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_enterNoteFrag_to_listNoteFrag);
                saveDataToDataBase();
            }
        });

        return binding.getRoot();

    }


    void saveDataToDataBase(){
        Long milis = new Date().getTime();
        Note note = new Note(binding.editText2.getText().toString(),binding.editText.getText().toString(),milis);
       NoteDao noteDao = NoteDataBase.getInstance(getContext()).noteDao();
       long result = noteDao.insertNote(note);
        Toast.makeText(getContext(), "data saved"+result, Toast.LENGTH_SHORT).show();
    }

}
