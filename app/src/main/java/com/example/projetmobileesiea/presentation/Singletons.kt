package com.example.projetmobileesiea.presentation

import com.example.projetmobileesiea.presentation.api.PokeItemApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Singletons {
    companion object {
        val pokeItemApi : PokeItemApi = Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PokeItemApi::class.java)
    }
}
