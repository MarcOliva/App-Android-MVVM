package com.marc.oliva.appmvvm.model

import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData
import com.marc.oliva.appmvvm.model.repository.CountriesRepository
import com.marc.oliva.appmvvm.model.repository.impl.CountriesRepositoryImpl

class CountryObservable :BaseObservable(){
    private var countryRepository:CountriesRepository=CountriesRepositoryImpl()
    //Repository
    fun callCountries(){
        countryRepository.callCountriesAPI()
    }

    //ViewModel
    fun getCountries(): MutableLiveData<List<Country>>{
        return countryRepository.getCountries()
    }
}