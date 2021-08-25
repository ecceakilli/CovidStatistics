package com.eceakilli.covidstatistics.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eceakilli.covidstatistics.AppClassApplication;
import com.eceakilli.covidstatistics.adapter.WorldAdapter;
import com.eceakilli.covidstatistics.databinding.FragmentWorldBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class WorldFragment extends Fragment {

    private ArrayList<String> worldFragmentArrayList;
    private FragmentWorldBinding worldBinding;
    WorldAdapter worldAdapter;

    ///////
    private Call<Map<String, Double>> call;
        ////////////////
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public WorldFragment() {
        // Required empty public constructor
    }

    public static WorldFragment newInstance(String param1, String param2) {
        WorldFragment fragment = new WorldFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        worldFragmentArrayList=new ArrayList<>();


        worldFragmentArrayList.add("adı");
        worldFragmentArrayList.add("adı");
        worldFragmentArrayList.add("adı");
        worldFragmentArrayList.add("adı");



        call = AppClassApplication.getInstance().getRestInterface().getWorldData();
        call.enqueue(new Callback<Map<String, Double>>() {
            @Override
            public void onResponse(Call<Map<String, Double>> call, Response<Map<String, Double>> response) {
                Log.e("basarılı",""+response.body().size());



                /*1
               worldFragmentArrayList=new ArrayList<String>(response.body().keySet());
               worldAdapter=new WorldAdapter(worldFragmentArrayList);

                 /*
                 Set setkey= response.body().keySet();
                  worldFragmentArrayList = new ArrayList<>(setkey);
                  worldAdapter=new WorldAdapter(worldFragmentArrayList);*/



            //adapter at --map ile çevir adaptri
                //map to arraylist convert!!! arastr
            }

            @Override
            public void onFailure(Call<Map<String, Double>> call, Throwable t) {
                Log.e("basarısız",""+t.getMessage());
            }
        });


        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        worldBinding = FragmentWorldBinding.inflate(inflater);
        View view = worldBinding.getRoot();

        worldBinding.rcyclerWorld.setLayoutManager(new LinearLayoutManager(getActivity()));
        worldAdapter=new WorldAdapter(worldFragmentArrayList);
        worldBinding.rcyclerWorld.setAdapter(worldAdapter);


        return view;
    }
}