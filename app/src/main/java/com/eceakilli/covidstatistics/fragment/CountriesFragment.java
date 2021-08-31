package com.eceakilli.covidstatistics.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eceakilli.covidstatistics.AppClassApplication;
import com.eceakilli.covidstatistics.R;
import com.eceakilli.covidstatistics.adapter.CountriesAdapter;
import com.eceakilli.covidstatistics.data.Country;
import com.eceakilli.covidstatistics.databinding.FragmentCountriesBinding;
import com.eceakilli.covidstatistics.databinding.FragmentWorldBinding;

import java.util.ArrayList;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountriesFragment extends Fragment {

    private FragmentCountriesBinding countriesBinding;
    private ArrayList<Country> countriesFragmentArraylist;
    CountriesAdapter countriesAdapter;
    private Call<ArrayList<Country>> call;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public CountriesFragment() {
    }

    public static CountriesFragment newInstance(String param1, String param2) {
        CountriesFragment fragment = new CountriesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        countriesFragmentArraylist=new ArrayList<>();


        call = AppClassApplication.getInstance().getRestInterface().getCountriesData();

        call.enqueue(new Callback<ArrayList<Country>>() {
            @Override
            public void onResponse(Call<ArrayList<Country>> call, Response<ArrayList<Country>> response) {
                Log.e("basarılı",""+response.body().size());

                countriesFragmentArraylist = response.body();
                countriesAdapter.changeData(countriesFragmentArraylist);


            }

            @Override
            public void onFailure(Call<ArrayList<Country>> call, Throwable t) {

            }
        });

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        countriesBinding= FragmentCountriesBinding.inflate(inflater);
        View view=countriesBinding.getRoot();

        countriesBinding.ryrclerCountries.setLayoutManager(new LinearLayoutManager(getActivity()));
        countriesAdapter=new CountriesAdapter(countriesFragmentArraylist);
        countriesBinding.ryrclerCountries.setAdapter(countriesAdapter);
        return view;
    }
}