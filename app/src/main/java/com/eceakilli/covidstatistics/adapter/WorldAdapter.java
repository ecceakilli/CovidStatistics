package com.eceakilli.covidstatistics.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eceakilli.covidstatistics.databinding.RecyclerWorldBinding;
import com.eceakilli.covidstatistics.fragment.WorldFragment;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class WorldAdapter extends RecyclerView.Adapter<WorldAdapter.WorldHolder> {

    private ArrayList<String> worldFragmentArrayList;

    public WorldAdapter(ArrayList<String> worldFragmentArrayList) {
        this.worldFragmentArrayList = worldFragmentArrayList;
    }




    @NonNull
    @Override
    public WorldHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerWorldBinding recyclerWorldBinding=RecyclerWorldBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new WorldHolder(recyclerWorldBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull WorldHolder holder, int position) {
        holder.binding.contentText.setText(worldFragmentArrayList.get(position));


    }

    @Override
    public int getItemCount() {
        return worldFragmentArrayList.size();
    }

    public class WorldHolder extends RecyclerView.ViewHolder {

    private RecyclerWorldBinding binding;
    public  int id;


        public WorldHolder(RecyclerWorldBinding binding) {
            super(binding.getRoot());
            this.binding=binding;

        }
    }
}
