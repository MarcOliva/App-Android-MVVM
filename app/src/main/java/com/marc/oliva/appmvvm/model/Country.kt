package com.marc.oliva.appmvvm.model


import com.google.gson.JsonObject
import java.io.Serializable
import java.lang.Exception

class Country(countryJson: JsonObject?) : Serializable {
    lateinit var name: String
    lateinit var uriFlag: String
    lateinit var capital: String
    lateinit var population: String
    lateinit var region: String
    lateinit var alpha3Code: String
    lateinit var area: String

    init {
        try {
            name = countryJson!!.get(NAME).asString
            uriFlag = countryJson.get(FLAG).asString
            capital = countryJson.get(CAPITAL).asString
            population = countryJson.get(POPULATION).asString
            region = countryJson.get(REGION).asString
            alpha3Code = countryJson.get(ALPHACODE).asString
            area = countryJson.get(AREA).asString


        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    companion object {
        private val NAME = "name"
        private val FLAG = "flag"
        private val CAPITAL = "capital"
        private val POPULATION = "population"
        private val REGION = "region"
        private val ALPHACODE = "alpha3Code"
        private val AREA = "area"
    }
}