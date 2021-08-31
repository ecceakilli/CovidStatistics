package com.eceakilli.covidstatistics.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eceakilli.covidstatistics.data.Country;
import com.eceakilli.covidstatistics.databinding.RecyclerCountriesBinding;
import com.eceakilli.covidstatistics.fragment.CountriesFragment;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.CountriesHolder> {

    ArrayList<Country> countriesFragmentArrayList;

    public CountriesAdapter(ArrayList<Country> countriesFragmentArrayList) {
        this.countriesFragmentArrayList = countriesFragmentArrayList;
    }

    public void changeData(ArrayList<Country> countriesFragmentArrayList){
        this.countriesFragmentArrayList = countriesFragmentArrayList;
        notifyItemRangeChanged(0, this.countriesFragmentArrayList.size());

    }


    @NonNull
    @Override
    public CountriesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerCountriesBinding recyclerCountriesBinding=RecyclerCountriesBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

        return new CountriesHolder(recyclerCountriesBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CountriesHolder holder, int position) {
        holder.binding.countriesName.setText(countriesFragmentArrayList.get(position).getCountyName());
        holder.binding.countriesCasesdtl.setText(countriesFragmentArrayList.get(position).getCases().toString());
        holder.binding.countriesDeathsdtl.setText(countriesFragmentArrayList.get(position).getDeaths().toString());
        holder.binding.countriesRecovereddtl.setText(countriesFragmentArrayList.get(position).getRecovered().toString());

        Picasso.get().load(countriesFragmentArrayList.get(position).getCountryInfo().getFlag()).into(holder.binding.imageFlag);




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
