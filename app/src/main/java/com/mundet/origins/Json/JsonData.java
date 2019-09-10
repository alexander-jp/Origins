package com.mundet.origins.Json;

import com.mundet.origins.Models.Home;
import com.mundet.origins.Models.ResultdHome;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonData {
    @GET("recientes")
    Call<ResultdHome> getDataUsers();
}
