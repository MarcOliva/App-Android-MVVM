package com.marc.oliva.appmvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ahmadrosid.svgloader.SvgLoader
import com.marc.oliva.appmvvm.R
import com.marc.oliva.appmvvm.model.Country
import kotlinx.android.synthetic.main.activity_detail_country.*

class DetailCountryActivity : AppCompatActivity() {

    lateinit var country: Country
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_country)
        supportActionBar?.hide()
        country = intent.extras?.get("country") as Country

        name_country_textview.text = country.name
        SvgLoader.pluck()
            .with(this)
            .setPlaceHolder(R.drawable.loading_spinner,R.drawable.loading_spinner)
            .load(country.uriFlag, flag_imageview)
        capital_textview.text = country.capital
        population_textview.text= country.population
        region_textview.text=country.region
        code_textview.text= country.alpha3Code
        area_textview.text= country.area

    }
}
