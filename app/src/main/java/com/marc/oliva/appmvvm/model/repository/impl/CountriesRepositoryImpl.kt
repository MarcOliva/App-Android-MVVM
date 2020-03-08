package com.marc.oliva.appmvvm.model.repository.impl

import androidx.lifecycle.MutableLiveData
import com.google.gson.JsonArray
import com.marc.oliva.appmvvm.model.repository.CountriesRepository
import com.marc.oliva.appmvvm.model.repository.api.ReferenceCountryService
import retrofit2.Call
import retrofit2.Response
import com.google.gson.JsonElement
import com.marc.oliva.appmvvm.model.Country
import retrofit2.Callback


class CountriesRepositoryImpl : CountriesRepository {
    private var countries = MutableLiveData<List<Country>>()

    override fun getCountries(): MutableLiveData<List<Country>> {
        return countries
    }


    override fun callCountriesAPI() {
        var countriesList: ArrayList<Country>? = ArrayList()
        val apiAdapter = ReferenceCountryService()
        val apiService = apiAdapter.getClientService()
        val call = apiService.listCountries()

        call.enqueue(object : Callback<JsonArray> {
            override fun onFailure(call: Call<JsonArray>, t: Throwable) {
                t.stackTrace
            }

            override fun onResponse(call: Call<JsonArray>, response: Response<JsonArray>) {
                val countriesJsonArray = response.body()
                countriesJsonArray?.forEach { jsonElement: JsonElement ->
                    val jsonObject = jsonElement.asJsonObject
                    val country = Country(jsonObject)
                    countriesList?.add(country)

                }
                countries.value = countriesList

            }

        })
    }

}