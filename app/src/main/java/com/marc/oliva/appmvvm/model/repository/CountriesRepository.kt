package com.marc.oliva.appmvvm.model.repository

import androidx.lifecycle.MutableLiveData
import com.marc.oliva.appmvvm.model.Country

interface CountriesRepository {
    fun getCountries(): MutableLiveData<List<Country>>
    fun callCountriesAPI()
}