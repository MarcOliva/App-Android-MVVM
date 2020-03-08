package com.marc.oliva.appmvvm.model.repository.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ReferenceCountryService{
    companion object{
        private const val URL_API= "https://restcountries.eu/rest/v2/"
    }

    fun getClientService(): CountriesService {
        var retrofit = Retrofit.Builder()
            .baseUrl(URL_API)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(CountriesService::class.java)
    }

}