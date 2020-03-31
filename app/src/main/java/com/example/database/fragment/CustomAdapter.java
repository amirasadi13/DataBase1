package com.example.database.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.database.R;

import java.util.ArrayList;

class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    ArrayList notes;
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
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title.setText((CharSequence) notes.get(position));
        holder.text.setText((CharSequence) notes.get(position));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView text;

        public MyViewHolder (View itemView){
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tv_title);
            text = (TextView) itemView.findViewById(R.id.tv_note);
        }
    }
}
