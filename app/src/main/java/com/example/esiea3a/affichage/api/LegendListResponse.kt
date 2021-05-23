package com.example.esiea3a.affichage.api

import com.example.esiea3a.affichage.list.Legend


data class LegendListResponse(
    val current_page : Int,
    val per_page : Int,
    val data : List<Legend>
)