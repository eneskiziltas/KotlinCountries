package com.eneskiziltas.kotlincountries3.service

import com.eneskiziltas.kotlincountries3.model.Country
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.POST

interface CountryAPI {

    //GET, POST
    //https://raw.githubusercontent.com/atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json
    //BASE_URL -> https://raw.githubusercontent.com/
    //EXT -> atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json


    @GET("atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json")
    fun getCountires():Single<List<Country>>

    //@POST() gibi call`ları da burada yapabiliriz

}