package com.example.projetmobileesiea.presentation

import com.example.projetmobileesiea.presentation.PokeItemApplication.Companion.context
import com.example.projetmobileesiea.presentation.api.PokeItemApi
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

class Singletons {
    companion object {
        var cache = Cache(File(context?.cacheDir, "responses"), 10 * 1024 * 1024) // 10 MiB
        val okHttpClient : OkHttpClient = OkHttpClient().newBuilder()
                .cache(cache)
                .build()
        val pokeItemApi : PokeItemApi = Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
                .create(PokeItemApi::class.java)

    }
}
