package com.eceakilli.covidstatistics.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eceakilli.covidstatistics.databinding.RecyclerWorldBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WorldAdapter extends RecyclerView.Adapter<WorldAdapter.WorldHolder> {

    private ArrayList<Map.Entry<String, Double>> worldFragmentArrayList;
    private HashMap<String, String> hashMap = new HashMap<String, String>();
    public WorldAdapter(ArrayList<Map.Entry<String, Double>> worldFragmentArrayList) {
        this.worldFragmentArrayList = worldFragmentArrayList;

        hashMap.put("updated","Güncel");
        hashMap.put("cases","Toplam vaka");
        hashMap.put("todayCases", "Bugün Vaka");
        hashMap.put("deaths", "Ölen kişi Sayısı");
        hashMap.put("todayDeaths", "Bugün Ölen kişi Sayısı");
        hashMap.put("recovered", "İyileşen");
        hashMap.put("todayRecovered", "Bugün iyileşen");
        hashMap.put("active", "Şuan ki Hasta Sayısı");
        hashMap.put("critical", "Kritik vaka");
        hashMap.put("casesPerOneMillion", "Bir milyonda vaka oranı");
        hashMap.put("deathsPerOneMillion", "Bir milyonda ölen oranı");
        hashMap.put("tests", "Test Sayısı");
        hashMap.put("testsPerOneMillion", "Bir milyonda test sayısı");
        hashMap.put("population", "Populasyon");
        hashMap.put("oneCasePerPeople", "oneCasePerPeople");
        hashMap.put("oneDeathPerPeople", "oneDeathPerPeople");
        hashMap.put("oneTestPerPeople", "oneTestPerPeople");
        hashMap.put("activePerOneMillion", "Bir milyonda aktif vaka oranı");
        hashMap.put("recoveredPerOneMillion", "Bir milyonda iyileşen kişi oranı");
        hashMap.put("criticalPerOneMillion", "Bir milyonda kritik kişi oranı");
        hashMap.put("affectedCountries", "Etkilenen ülke Sayısı");

    }



    public void changeData(ArrayList<Map.Entry<String, Double>> worldFragmentArrayList) {
        this.worldFragmentArrayList = worldFragmentArrayList;
        notifyItemRangeChanged(0, this.worldFragmentArrayList.size());
    }


    @NonNull
    @Override
    public WorldHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerWorldBinding recyclerWorldBinding=RecyclerWorldBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new WorldHolder(recyclerWorldBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull WorldHolder holder, int position) {
       // holder.binding.titleText.setText(worldFragmentArrayList.get(position).getKey());
        holder.binding.contentText.setText(worldFragmentArrayList.get(position).getValue().toString());

        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            if (worldFragmentArrayList.get(position).getKey().contains(entry.getKey())){

                holder.binding.titleText.setText(entry.getValue());
                return;
            }

        }




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
