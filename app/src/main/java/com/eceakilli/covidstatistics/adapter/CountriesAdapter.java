package com.eceakilli.covidstatistics.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eceakilli.covidstatistics.databinding.RecyclerCountriesBinding;
import com.eceakilli.covidstatistics.fragment.CountriesFragment;

import java.util.ArrayList;

public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.CountriesHolder> {

    ArrayList<String> countriesFragmentArrayList;

    public CountriesAdapter(ArrayList<String> countriesFragmentArrayList) {
        this.countriesFragmentArrayList = countriesFragmentArrayList;
    }


    @NonNull
    @Override
    public CountriesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerCountriesBinding recyclerCountriesBinding=RecyclerCountriesBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

        return new CountriesHolder(recyclerCountriesBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CountriesHolder holder, int position) {
        holder.binding.countriesName.setText(countriesFragmentArrayList.get(position));
        //suan için bir yaptın gerisini hallet
    }

    @Override
    public int getItemCount() {
        return countriesFragmentArrayList.size();
    }

    public class CountriesHolder extends RecyclerView.ViewHolder {

        private RecyclerCountriesBinding binding;


        public CountriesHolder(RecyclerCountriesBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
