package com.mundet.origins.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mundet.origins.Json.JsonData;
import com.mundet.origins.Models.Home;
import com.mundet.origins.Models.ResultdHome;
import com.mundet.origins.R;
import com.mundet.origins.RetrofitUrl.UrlDomain;
import com.mundet.origins.adapters.RecyclerViewAdapterHome;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class fragmentHome extends Fragment {
    //@BindView(R.id.recyclerViewFragmentHome)
    RecyclerView recyclerView;
    RecyclerViewAdapterHome recyclerViewAdapterHome;
    Home arrayList;
    ArrayList<Home> homes;
    RecyclerView.LayoutManager layoutManager;
    UrlDomain urlDomain = new UrlDomain();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(getActivity());
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewFragmentHome);
        layoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        //loadData();

        //arrayList = Home().;
        //recyclerViewAdapterHome = new RecyclerViewAdapterHome(arrayList, getActivity());
        //recyclerView.setAdapter(recyclerViewAdapterHome);
        return view;
    }


    private void loadData() {
        /*Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://cinetux.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        JsonData service = retrofit.create(JsonData.class);*/
        JsonData service = urlDomain.UrlDomimio().create(JsonData.class);
        Call<ResultdHome> call = service.getDataUsers();
        //Toast.makeText(getActivity(), "aki estoy", Toast.LENGTH_SHORT).show();
        call.enqueue(new Callback<ResultdHome>() {

            @Override
            public void onResponse(Call<ResultdHome> call, Response<ResultdHome> response) {
                Log.i("prueba alexander", "hola como estas");
                if (response.isSuccessful()) {
                    Log.i("resultado Home", response.body().toString());
                    ResultdHome resultaHome = response.body();
                    // System.out.print(resultaHome.toString());
                    homes = new ArrayList<>(Arrays.asList(resultaHome.getResultado()));
                    recyclerViewAdapterHome = new RecyclerViewAdapterHome(homes, getContext());
                    recyclerView.setAdapter(recyclerViewAdapterHome);
                } else {
                    //Toast.makeText(getActivity(), "aki estoy", Toast.LENGTH_SHORT).show();
                    Log.i("Mensaje de error: ", "Hubo un error al obtener los datos");
                }
            }

            @Override
            public void onFailure(Call<ResultdHome> call, Throwable t) {

            }
        });

    }

    @Override
    public void onResume() {
        loadData();
        super.onResume();
    }
}
