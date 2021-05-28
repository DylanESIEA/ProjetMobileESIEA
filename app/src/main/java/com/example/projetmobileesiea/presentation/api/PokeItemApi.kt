package com.example.projetmobileesiea.presentation.api

import retrofit2.Call
import retrofit2.http.GET

interface PokeItemApi {
    @GET("item")
    fun getDigimonList() : Call<PokeItemResponse>

}