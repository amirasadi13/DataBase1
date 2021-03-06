package com.example.database.fragment;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.database.R;
import com.example.database.database.Note;
import com.example.database.database.NoteDao;
import com.example.database.database.NoteDataBase;
import com.example.database.databinding.FragmentEditItemsBinding;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class EditItemsFrag extends Fragment {


    FragmentEditItemsBinding binding;
    NoteDao noteDao;
    CustomAdapter customAdapter;
    ArrayList<Note> notes;
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_edit_items, container, false);

        binding.editText3.setText(getArguments().getString("title"));
        binding.editText4.setText(getArguments().getString("text"));

        binding.floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newTitle =binding.editText3.getText().toString();
                String newText =binding.editText4.getText().toString();
                int id = getArguments().getInt("item_id");
                NoteDao noteDao =NoteDataBase.getInstance(getContext()).noteDao();
                Long milis = new Date().getTime();
                Note note = new Note(newText,newTitle,milis);
                note.setNote_id(id);
                noteDao.updateNote(note);
                Navigation.findNavController(v).navigate(R.id.action_editItemsFrag_to_listNoteFrag);
            }
        });



        return binding.getRoot();
    }


}
