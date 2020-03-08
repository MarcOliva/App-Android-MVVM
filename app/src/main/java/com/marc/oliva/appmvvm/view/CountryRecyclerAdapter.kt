package com.marc.oliva.appmvvm.view

import android.view.LayoutInflater

import android.view.ViewGroup

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

import com.marc.oliva.appmvvm.BR

import com.marc.oliva.appmvvm.model.Country
import com.marc.oliva.appmvvm.viewmodel.CountryViewModel


class CountryRecyclerAdapter(var countryViewModel: CountryViewModel, var resource: Int) :
    RecyclerView.Adapter<CountryRecyclerAdapter.CardCountryHolder>() {

    var countries: List<Country>? = null

    fun setCountriesList(countries: List<Country>) {
        this.countries = countries
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardCountryHolder {

        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding =
            DataBindingUtil.inflate(layoutInflater, viewType, parent, false)
        return CardCountryHolder(binding)
    }

    override fun getItemCount(): Int {
        return countries?.size ?: 0
    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutIdForPosition(position)
    }

    override fun onBindViewHolder(holder: CardCountryHolder, position: Int) {

        holder.setDataCard(countryViewModel,position)
    }
    fun getLayoutIdForPosition(position: Int): Int{
        return resource
    }

    class CardCountryHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        private var binding:ViewDataBinding?=null

        init {
            this.binding=binding
        }

        fun setDataCard(countryViewModel: CountryViewModel,position: Int) {

            binding?.setVariable(BR.model,countryViewModel)
            binding?.setVariable(BR.position,position)
            binding?.executePendingBindings()

        }

    }


}