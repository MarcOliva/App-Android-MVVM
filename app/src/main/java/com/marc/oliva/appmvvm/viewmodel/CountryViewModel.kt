package com.marc.oliva.appmvvm.viewmodel

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.AsyncTask
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ahmadrosid.svgloader.SvgLoader
import com.marc.oliva.appmvvm.R
import com.marc.oliva.appmvvm.model.Country
import com.marc.oliva.appmvvm.model.CountryObservable
import com.marc.oliva.appmvvm.view.CountryRecyclerAdapter
import com.marc.oliva.appmvvm.view.DetailCountryActivity
import com.marc.oliva.appmvvm.view.MainActivity
import java.net.HttpURLConnection
import java.net.URL


class CountryViewModel : ViewModel() {
    private var countryObservable: CountryObservable = CountryObservable()
    private var countryRecyclerAdapter: CountryRecyclerAdapter? = null
    fun callCountries() {
        countryObservable.callCountries()
    }

    fun getCountries(): MutableLiveData<List<Country>> {
        return countryObservable.getCountries()
    }

    fun setCountriesInRecyclerAdapter(countries: List<Country>) {
        countryRecyclerAdapter?.setCountriesList(countries)
        countryRecyclerAdapter?.notifyDataSetChanged()
    }

    fun getRecyclerCountriesAdapter(): CountryRecyclerAdapter? {
        countryRecyclerAdapter = CountryRecyclerAdapter(this, R.layout.item_country)
        return countryRecyclerAdapter
    }

    fun getCountryAt(position: Int): Country? {
        var countries: List<Country>? = countryObservable.getCountries().value
        return countries?.get(position)
    }


    companion object {
        var mainActivity: MainActivity? = null
        @JvmStatic
        @BindingAdapter("svgSrc")
        fun setFlag(imageView: ImageView, uriFlag: String) {
            SvgLoader.pluck()
                .with(mainActivity)
                .setPlaceHolder(R.drawable.loading_spinner, R.drawable.loading_spinner)
                .load(uriFlag, imageView)
        }
        @JvmStatic
        @BindingAdapter("showDetails")
        fun openDetailsActivity(view: View, country: Country) {
            view.setOnClickListener {
                val showCountryIntent = Intent(view.context, DetailCountryActivity::class.java)
                showCountryIntent.putExtra("country", country)
                view.context.startActivity(showCountryIntent)
            }

        }
    }


}