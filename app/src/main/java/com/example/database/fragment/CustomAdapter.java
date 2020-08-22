package com.example.database.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.database.R;
import com.example.database.database.Note;
import com.example.database.database.NoteDao;
import com.example.database.database.NoteDataBase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    ArrayList<Note> notes;
    Fragment context;

    public CustomAdapter (Fragment context , ArrayList notes){
        this.notes = notes;
        this.context =context;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listofnotes,parent,false);
        MyViewHolder recyclerView = new MyViewHolder(view);
        return recyclerView;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.title.setText(notes.get(position).getTitle());
        holder.text.setText(notes.get(position).getContent());

        Long milis = notes.get(position).getTime();
        Date date =new Date(milis);
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("hh:mm");
        String timeFormat =simpleDateFormat.format(date);
        holder.time.setText(timeFormat);
        holder.menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                        final PopupMenu popupMenu = new PopupMenu(v.getContext(),holder.menu);
                        popupMenu.getMenuInflater().inflate(R.menu.popupmenu,popupMenu.getMenu());
                        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem item) {
                                if (item.getItemId() == R.id.menu_delete_btn){
                                    NoteDao noteDao = NoteDataBase.getInstance(v.getContext()).noteDao();
                                    Note note = notes.get(position);
                                    noteDao.deleteNote(note);
                                    notes.remove(position);
                                    notifyDataSetChanged();
                                }else if (item.getItemId() == R.id.menu_open_btn){
                                    Note note = notes.get(position);
                                    String title = note.getTitle();
                                    String text = note.getContent();
                                    Bundle bundle = new Bundle();
                                    bundle.putString("title",title);
                                    bundle.putString("text",text);
                                    Navigation.findNavController(v).navigate(R.id.action_listNoteFrag_to_openItemsFrag,bundle);




                                }else if(item.getItemId() == R.id.menu_edit_btn){
                                    NoteDao noteDao =NoteDataBase.getInstance(v.getContext()).noteDao();
                                    Note note =notes.get(position);
                                    String title =note.getTitle();
                                    String text =note.getContent();
                                    int id =note.getNote_id();
                                    Bundle bundle =new Bundle();
                                    bundle.putString("title",title);
                                    bundle.putString("text",text);
                                    bundle.putInt("item_id",id);
                                    Navigation.findNavController(v).navigate(R.id.action_listNoteFrag_to_editItemsFrag,bundle);
                                }
                                return true;
                            }
                        });
                        popupMenu.show();

                    }
        });
    }


    @Override
    public int getItemCount() {
        return notes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView text;
        TextView time;
        ImageView menu;

        public MyViewHolder (View itemView){
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tv_title);
            text = (TextView) itemView.findViewById(R.id.tv_note);
            menu = (ImageView) itemView.findViewById(R.id.menu_btn);
            time = (TextView) itemView.findViewById(R.id.tv_time);
        }
    }
}
