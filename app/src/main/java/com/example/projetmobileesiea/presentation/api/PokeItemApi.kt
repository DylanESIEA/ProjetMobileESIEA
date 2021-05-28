package com.example.projetmobileesiea.presentation.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeItemApi {
    @GET("item")
    fun getDigimonList() : Call<PokeItemListResponse>

    @GET("item/{id}")
    fun getPokeItemDetail(@Path("id") id: String) : Call<PokeItemDetailResponse>

}