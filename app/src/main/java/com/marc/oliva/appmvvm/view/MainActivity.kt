package com.marc.oliva.appmvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.marc.oliva.appmvvm.R
import com.marc.oliva.appmvvm.model.Country
import com.marc.oliva.appmvvm.viewmodel.CountryViewModel

class MainActivity : AppCompatActivity() {

    private var countryViewModel:CountryViewModel?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        //VIEW
        setupBindings(savedInstanceState)
    }

    fun setupBindings(savedInstanceState: Bundle?){
        val activityMainBinding:com.marc.oliva.appmvvm.databinding.ActivityMainBinding
        =DataBindingUtil.setContentView(this,R.layout.activity_main)
        countryViewModel= ViewModelProviders.of(this).get(CountryViewModel::class.java)

        activityMainBinding.model=countryViewModel
        setupListUpdate()
    }
    fun setupListUpdate(){
        //Call countries
        countryViewModel?.callCountries()
        //getCountries
        countryViewModel?.getCountries()?.observe(this, Observer {
            countries:List<Country>->
            CountryViewModel.mainActivity=this
            countryViewModel?.setCountriesInRecyclerAdapter(countries)

        })
    }
}
