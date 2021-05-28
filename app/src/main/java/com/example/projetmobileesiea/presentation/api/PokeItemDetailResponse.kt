package com.example.projetmobileesiea.presentation.api

data class PokeItemDetailResponse(
        val name: String,
        val effect_entries : List<PokeItemEffect>

)

data class PokeItemEffect (
        val effect : String,
        val language : LanguageItem
)

data class LanguageItem (
        val name : String,
        val url : String
)