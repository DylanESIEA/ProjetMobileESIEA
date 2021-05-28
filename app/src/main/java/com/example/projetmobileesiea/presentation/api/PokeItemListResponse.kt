package com.example.projetmobileesiea.presentation.api

import com.example.projetmobileesiea.presentation.list.item

data class PokeItemListResponse (
    val count : Int,
    val next : String,
    val results : List<item>

)