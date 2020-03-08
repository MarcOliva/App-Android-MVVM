package com.marc.oliva.appmvvm.model.repository.api

import com.google.gson.JsonArray
import retrofit2.Call
import retrofit2.http.GET


interface CountriesService {
    @GET("all")
    fun listCountries(): Call<JsonArray>
}